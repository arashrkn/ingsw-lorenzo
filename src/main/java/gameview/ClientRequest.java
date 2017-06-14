package gameview;


import gamemodel.actionSpace.ActionSpace;

import java.io.Serializable;

import gamemodel.*;

public class ClientRequest  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequestType type;
	private int where;
	private int servants;
	private Color which;
	private String answer;
	private Player player;
	
	public ClientRequest(String string) {
		type = RequestType.ANSWER;
		answer = string;
	}

	public ClientRequest() {
		super();
	}
	
	public void setType(RequestType type) {
		this.type = type;
	}
	
	public void setServants(String servants) {
		this.servants= Integer.parseInt(servants);
	}
		
	public RequestType getType() {
		return type;
	}
	
	public void setWhere(ActionSpace where){
		this.where=where.getId();
	}
	
	public void setWhich(FamilyMember which){
		this.which=which.getColor();
		
	}
	

	public int getWhere() {
		return where;
	}

	public int getServants() {
		return servants;
	}

	public Color getWhich() {
		return which;
	}
	
	public void setPlayer(Player player){
		this.player=player;
	}

	@Override
	public String toString() {
		return "ClientRequest [type=" + type + ", where=" + where + ", servants=" + servants + ", which=" + which
				+ ", answer=" + answer + "]";
	}

	public void cleanUp() {
	}

	public void setAnswer(String answer) {
		this.type = RequestType.ANSWER;
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public Player getPlayer() {
		return player;
	}

}
