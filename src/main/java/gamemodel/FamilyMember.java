package gamemodel;

public class FamilyMember {
	@Override
	public String toString() {
		return "FamilyMember [player=" + player + ", actionPoint=" + actionPoint + ", color=" + color + ", used=" + used
				+ "]";
	}

	private RealPlayer player;
	private int actionPoint=0;
	private Color color;
	private boolean used=false;
	
	public FamilyMember(RealPlayer player, Color color) {
		this.player = player;
		this.color = color;
	}
	
	public FamilyMember clone() {
		FamilyMember fm = new FamilyMember(player, color);
		fm.setActionpoint(actionPoint);
		fm.setUse(this.used);
		return fm;
	}
	
	public void setUse(Boolean used){
		this.used=used;
	}
	
	public void use(){
		this.used=true;
	}


	public boolean isUsed(){
		return used;
	}
	
	public void prepareForNewRound(){
		this.used=false;
	}

	public RealPlayer getPlayer() {
		return player;
	}

	public int getActionpoint() {
		return actionPoint;
	}

	public void setActionpoint(int actionpoint) {
		this.actionPoint = actionpoint;
	}

	public Color getColor() {
		return color;
	}
	

}