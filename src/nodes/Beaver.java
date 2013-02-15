package nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Summoning;

import smoothWC.Variables;

public class Beaver extends Node {

	@Override
	public boolean activate() {
		if(Summoning.getPoints() > 5 && Variables.choppingArea.contains(Players.getLocal().getLocation()))
			return !Summoning.isFamiliarSummoned() || Summoning.getTimeLeft() < 1;
		return false;
		
	}

	@Override
	public void execute() {
		Variables.status = "Summoning Beaver";
		if(Inventory.getItem(Variables.beaver_ID) != null){
			Inventory.getItem(Variables.beaver_ID).getWidgetChild().interact("Summon");
		}else Variables.status = "No Beaver pouches";
		
	}

}