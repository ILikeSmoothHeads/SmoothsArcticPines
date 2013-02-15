package nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;

import smoothWC.Variables;

public class WalkToArea extends Node{

	@Override
	public boolean activate() {
		if(!Variables.choppingArea.contains(Players.getLocal().getLocation()) && !Variables.bridgeSide2.contains(Players.getLocal().getLocation()))
				return true;
		return false;
	}

	@Override
	public void execute() {
		Variables.status = "Walking to area";
		Walking.walk(Variables.choppingTiles[2]);
		
	}

}
