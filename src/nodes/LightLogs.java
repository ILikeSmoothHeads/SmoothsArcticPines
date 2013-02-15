package nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;

import smoothWC.Variables;

public class LightLogs extends Node {

	
	
	@Override
	public boolean activate() {
		SceneObject tree = SceneEntities.getNearest(Variables.arcticPine_ID);
		if(Variables.choppingArea.contains(Players.getLocal().getLocation())){
			if(Inventory.contains(Variables.articLogs_ID))
				return true;
		}
		return false;
	}

	@Override
	public void execute() {
		SceneObject tree = SceneEntities.getNearest(Variables.arcticPine_ID);
		int x = Inventory.getCount(Variables.articLogs_ID);
		
		Variables.status = "Dropping logs";
		for(int i = 0; i <= x; i++){
			Keyboard.sendKey('1');
		}
	
			
		
		if(!Inventory.isFull()){
			Variables.status = "Chopping trees";
			//Variables.logsChopped++;
			tree.interact("Chop");
			sleep(700,800);
		}
		
		
	}

}
