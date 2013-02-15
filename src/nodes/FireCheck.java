package nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import smoothWC.Variables;

public class FireCheck extends Node{

	@Override
	public boolean activate() {
		SceneObject fire = SceneEntities.getNearest(Variables.fire_ID);
		if(fire != null){
			if(Players.getLocal().getLocation().equals(fire.getLocation()))
				return true;
		}
		return false;
	}

	@Override
	public void execute() {
		Variables.status = "Moving from fire";
		SceneObject fire = SceneEntities.getNearest(Variables.fire_ID);
		if(Players.getLocal().getLocation().equals(Variables.choppingTiles[1]) || Players.getLocal().getLocation().equals(Variables.choppingTiles[0])){
			Walking.walk(Variables.fireTile1);
			sleep(1000,1200);
			Camera.setPitch(50);
		} else if(Players.getLocal().getLocation().equals(Variables.choppingTiles[2]) || Players.getLocal().getLocation().equals(Variables.choppingTiles[3])){
			Walking.walk(Variables.fireTile2);
			sleep(1000,1200);
		} else if(Players.getLocal().getLocation().equals(Variables.choppingTiles[4]) || Players.getLocal().getLocation().equals(Variables.choppingTiles[5])){
			Walking.walk(Variables.fireTile3);
			sleep(1000,1200);
		} else {
			Walking.walk(Variables.fireTile4); 
			System.out.println("not in area");
			sleep(1000,1200);
		}
			
		
		
	}

}
