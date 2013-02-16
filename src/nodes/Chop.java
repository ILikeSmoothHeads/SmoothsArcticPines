package nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import smoothWC.Variables;



public class Chop extends Node {
	

	@Override
	public boolean activate() {
		SceneObject tree = SceneEntities.getNearest(Variables.arcticPine_ID);
		if(Variables.choppingArea.contains(Players.getLocal().getLocation())){
			if(!Inventory.contains(Variables.articLogs_ID)){
				if(Players.getLocal().getAnimation() == -1 || Players.getLocal().getAnimation() == 16700){
					if(tree != null){
						return true;
					}
				}
			}
		}
		
			return false;
		
		
		
	}

	@Override
	public void execute() {
		Variables.status = "Chopping trees";
		SceneObject tree = SceneEntities.getNearest(Variables.arcticPine_ID);
		if(tree.isOnScreen()){
			if(!Players.getLocal().isMoving()){
				System.out.println("Chopping");
				tree.interact("Chop");
				sleep(1000,1200);
			}
		} else Camera.turnTo(tree);
		
		
		
	}

}
