package nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Summoning;

import smoothWC.Variables;

public class Beaver extends Node {

	@Override
	public boolean activate() {
		if(Variables.choppingArea.contains(Players.getLocal().getLocation()))
			return !Summoning.isFamiliarSummoned() && Summoning.getPoints() > 5;
		return false;
		
	}

	@Override
	public void execute() {
		Variables.status = "Summoning Beaver";
		if(Inventory.getItem(Variables.beaver_ID) != null){
			Inventory.getItem(Variables.beaver_ID).getWidgetChild().interact("Summon");
			sleep(1000,1200);
		}else Variables.status = "No Beaver pouches";
		
	}

}
