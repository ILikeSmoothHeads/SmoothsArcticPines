package nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Summoning;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.node.SceneObject;

import smoothWC.Variables;

public class RenewPoints extends Node{

	@Override
	public boolean activate() {
		return Summoning.getPoints() < 5;
	}

	@Override
	public void execute() {
		Variables.status = "Walking to obelisk";
		SceneObject bridge = SceneEntities.getNearest(Variables.bridge_ID);
		SceneObject obelisk = SceneEntities.getNearest(Variables.obelisk_ID);
		if(!Variables.bridgeSide2.contains(Players.getLocal().getLocation())){
			Walking.walk(Variables.bridgeTile1);
			sleep(1000,1200);
		
			if(bridge != null){
				bridge.interact("Walk-across");
				sleep(10000,12000);
			}
		}
		if(Variables.bridgeSide2.contains(Players.getLocal().getLocation()) && !obelisk.isOnScreen()){
			Walking.walk(Variables.obeliskTile);
			sleep(1000,1200);
		}
		Variables.status = "Renewing points";
		if(obelisk.isOnScreen()){
			obelisk.interact("Renew-points");
		} else Camera.turnTo(obelisk);
		
	}

}
