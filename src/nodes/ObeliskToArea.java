package nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Summoning;
import org.powerbot.game.api.wrappers.node.SceneObject;

import smoothWC.Variables;

public class ObeliskToArea extends Node{

	@Override
	public boolean activate() {
		return Variables.bridgeSide2.contains(Players.getLocal().getLocation()) && Summoning.getPoints() > 5;
	}

	@Override
	public void execute() {
		Variables.status = "walking back to area";
		Walking.walk(Variables.bridgeTile2);
		sleep(1000,1200);
		SceneObject bridge = SceneEntities.getNearest(Variables.bridge_ID);
		if(bridge != null && bridge.isOnScreen()){
			bridge.interact("Walk-across");
			sleep(10000,12000);
		}
		
		
	}

}
