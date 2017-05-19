package gamemodel.ActionSpace;

import java.util.ArrayList;
import java.util.List;

import gamemodel.Effect;
import gamemodel.FamilyMember;
import gamemodel.Player;
import gamemodel.RealPlayer;

public class MemoryActionSpace extends RealActionSpace implements ActionSpace {
	
	private List<RealPlayer> players=new ArrayList<RealPlayer>();

	public MemoryActionSpace(int actionCost, Effect effect, ActionSpaceType type) {
		super(actionCost, effect, type);
	}
	
	public List<RealPlayer> getPlayers() {
		return players;
	}

	public boolean controlPlayer(FamilyMember f) {
		for(Player p:players)
			if(p.equals(f.getPlayer()))
				return false;
		return true;
	}

	public void addPlayer(FamilyMember f){
		players.add(f.getPlayer());
	}
}