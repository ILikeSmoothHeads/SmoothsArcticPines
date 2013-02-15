package smoothWC;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFrame;

import nodes.Beaver;
import nodes.Chop;
import nodes.FireCheck;
import nodes.LightLogs;
import nodes.LootNests;
import nodes.ObeliskToArea;
import nodes.OpenNest;
import nodes.RenewPoints;
import nodes.SendUrns;
import nodes.WalkToArea;

import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Skills;


@Manifest (authors ={"ILikeSmoothHeads"},
name = "Epic Arctic Pines",
description = "Chops and drops Artic Pine Logs! ",
version = 1.0)

public class ArcticPines extends ActiveScript implements PaintListener, MessageListener, MouseListener {

	private Tree jobContainer = null;
	
	
	public void onStart() {
		
		System.out.println("Welcome!");
		
		Gui g = new Gui();
		g.setVisible(true);
		g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		g.setTitle("Settings");
		
		Variables.status = "loading";
		
		
		if(Variables.actionBarButton.visible())
			Variables.actionBarButton.click(true);
		
		Variables.summPoints = Skills.getLevel(Skills.SUMMONING);
		Variables.startingLogs = Inventory.getCount(Variables.articLogs_ID);
		Variables.wcStartingXp = Skills.getExperience(Skills.WOODCUTTING);
		Variables.startTime = System.currentTimeMillis();
		Variables.startingUrns = Inventory.getCount(Variables.fullUrn_ID);
		
			try {
				Variables.price0 = Integer.parseInt(getPrice(Variables.seed_IDs[0]).replace(",",""));
				Variables.price1 = Integer.parseInt(getPrice(Variables.seed_IDs[1]).replace(",",""));
				Variables.price2 = Integer.parseInt(getPrice(Variables.seed_IDs[2]).replace(",",""));
				Variables.price3 = Integer.parseInt(getPrice(Variables.seed_IDs[3]).replace(",",""));
				Variables.price4 = Integer.parseInt(getPrice(Variables.seed_IDs[4]).replace(",",""));
				Variables.price5 = Integer.parseInt(getPrice(Variables.seed_IDs[5]).replace(",",""));
				Variables.price6 = Integer.parseInt(getPrice(Variables.seed_IDs[6]).replace(",",""));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			Variables.startingProfit = Variables.price0*Inventory.getCount(Variables.seed_IDs[0]) + 
					Variables.price1*Inventory.getCount(Variables.seed_IDs[1]) + 
					Variables.price2*Inventory.getCount(Variables.seed_IDs[2]) +
					Variables.price3*Inventory.getCount(Variables.seed_IDs[3]) + 
					Variables.price4*Inventory.getCount(Variables.seed_IDs[4]) + 
					Variables.price5*Inventory.getCount(Variables.seed_IDs[5]) +
					Variables.price6*Inventory.getCount(Variables.seed_IDs[6]);
		
	}
	
	
	public void onStop() {
		stop();
	}
	
	@Override
	public int loop() {
		if(!Variables.guiOpen){
			
			
		
			if(Variables.beaver)
				
			Variables.profit = Variables.price0*Inventory.getCount(Variables.seed_IDs[0]) + 
					Variables.price1*Inventory.getCount(Variables.seed_IDs[1]) + 
					Variables.price2*Inventory.getCount(Variables.seed_IDs[2]) +
					Variables.price3*Inventory.getCount(Variables.seed_IDs[3]) + 
					Variables.price4*Inventory.getCount(Variables.seed_IDs[4]) + 
					Variables.price5*Inventory.getCount(Variables.seed_IDs[5]) +
					Variables.price6*Inventory.getCount(Variables.seed_IDs[6])  - Variables.startingProfit;
		
			if (jobContainer != null) {
	            final Node job = jobContainer.state();
	
	            if (job != null) {
	                jobContainer.set(job);
	                getContainer().submit(job);
	                job.join();
	            }
			}else {
				
				Variables.jobs.add(new FireCheck());
	            Variables.jobs.add(new Chop());
	            Variables.jobs.add(new LightLogs());
	            Variables.jobs.add(new WalkToArea());
	            if(Variables.urns)
	            	Variables.jobs.add(new SendUrns());
	            if(Variables.nests){
	            	Variables.jobs.add(new LootNests());
	            	Variables.jobs.add(new OpenNest());
	            }
	            if(Variables.beaver)
	            	Variables.jobs.add(new Beaver());
	            	Variables.jobs.add(new RenewPoints());
	            	Variables.jobs.add(new ObeliskToArea());
	            	

	            
	
	            jobContainer = new Tree(
	                    Variables.jobs.toArray(new Node[Variables.jobs
	                            .size()]));
	        }
		}
		
	    
	    
		return 50;
	}

	
	public void onRepaint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	
	    Variables.currentTime = System.currentTimeMillis() - Variables.startTime;
	    
	    Variables.wcGainedXp = Skills.getExperience(Skills.WOODCUTTING) - Variables.wcStartingXp;
	    Variables.xpHour = (int) (Variables.wcGainedXp * 3600000D / Variables.currentTime);
	    Variables.logsHour = (int) (Variables.logsChopped * 3600000D / Variables.currentTime);
	    
	    if(Variables.showPaint){
	    	g.drawImage(Variables.proggyImg, 0, 346, null);
	    
	    	if(!Variables.guiOpen){
			    g.setFont(Variables.font1);
			    g.setColor(Color.RED);
			    g.drawString("" + format(Variables.currentTime), 235, 413);
			    g.drawString("" + Variables.logsChopped + "   (" + Variables.logsHour + " per hour)", 240, 434);
			    g.drawString("" + Variables.wcGainedXp + "   (" + Variables.xpHour + " per hour)", 210, 455);
			    g.drawString("" + Variables.urnsFilled, 205, 476);
			    g.drawString("" + Variables.nestsLooted, 228, 498);
			    g.drawString("" + Variables.profit, 165, 519);
			    g.drawString("Status: " + Variables.status, 250, 519);
		    }
	    }
	  //  g.setColor(Color.WHITE);
	   // g.fillRect(465, 390, 50, 20);
	    g.setColor(Color.RED);
	    g.setFont(Variables.font2);
	    g.drawString("Toggle", 466, 405);
	    
	}
	
	public String format(final long ms) {
        int seconds = (int) ms / 1000;
        int minutes = seconds / 60;
        seconds -= minutes * 60;
        int hours = minutes / 60;
        minutes -= hours * 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
	
	public static String getPrice(int id) throws IOException {
        URL url = new URL("http://open.tip.it/json/ge_single_item?item=" + id);
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));

        String line = "";
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            line += inputLine;
        }

        in.close(); // Remember to close it kids, cakemix loves memory.

        if (!line.contains("mark_price"))
            return "-1";

        line = line.substring(line.indexOf("mark_price\":\"")
                + "mark_price\":\"".length());
        line = line.substring(0, line.indexOf("\""));

        return line;
    }


	@Override
	public void messageReceived(MessageEvent message) {
		if(message.getMessage().contains("get some arctic pine"))
			Variables.logsChopped++;
		
	}
	
	public void dropLogs(){
		for(int i = 0; i< Inventory.getCount(Variables.articLogs_ID); i++){
			Keyboard.sendKey('1');
		}
	}
	public Rectangle toggle() {
		Rectangle r = new Rectangle(465, 390, 50, 20);
		
		return r;
		
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		Rectangle r = new Rectangle(465, 390, 50, 20);
		Rectangle m = new Rectangle(Mouse.getX(), Mouse.getY(), 2, 2);
		if(r.intersects(m))
			if(Variables.showPaint){
				Variables.showPaint = false;
			}else Variables.showPaint = true;
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}