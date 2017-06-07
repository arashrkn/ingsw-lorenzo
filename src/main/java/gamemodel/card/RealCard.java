package gamemodel.card;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gamemodel.Player;
import gamemodel.Point;
import gamemodel.Resource;
import gamemodel.command.GameException;
import gamemodel.effects.IstantEffect;

public class RealCard implements Card,Serializable {
	
	private static final long serialVersionUID = 1L;
	protected String name;
	private int period;
	protected Resource resourceRequirement;
	protected Resource resourcePrice;
	protected Point pointRequirement;
	protected Point pointPrice;
	protected List<IstantEffect> istantEffect;
	protected CardType type;
	protected final int id;
	private static int identifier=0;
	protected Map<CardType,Integer> requirementCard=new HashMap<>();
	
	public RealCard(String name,int period,Resource resourceRequirement, Resource resourcePrice, Point point, 
			Point pointPrice, List<IstantEffect> istantEffects, CardType type,
			Map<CardType, Integer> requirementCard) {	
		this.name=name;
		this.period=period;
		this.id=identifier;
		identifier++;
		this.resourceRequirement = resourceRequirement;
		this.resourcePrice = resourcePrice;
		this.pointRequirement = point;
		this.pointPrice = pointPrice;
		this.type = type;
		this.requirementCard = requirementCard;
		this.istantEffect=istantEffects;
	}
		

	public boolean controlResource(Player p,Resource discount){
		if(resourceRequirement!=null)
			return p.isEnoughtResource(resourceRequirement.minus(discount));
		if(pointRequirement!=null)
			return p.isEnoughtPoint(pointRequirement);
		if(!requirementCard.isEmpty())
			return(requirementCard.get(CardType.BUILDINGS)>=p.contCard(CardType.BUILDINGS)) 
					&&(requirementCard.get(CardType.CHARACTERS)>=p.contCard(CardType.CHARACTERS))
					&&(requirementCard.get(CardType.VENTURES)>=p.contCard(CardType.VENTURES))
					&&(requirementCard.get(CardType.TERRITORIES)>=p.contCard(CardType.TERRITORIES));
		return true;		
	}

	@Override
	public void pay(Player p,Resource discount){
		if(resourcePrice!=null)
			p.subResources(resourcePrice.minus(discount));	
		if(pointPrice!=null)
			p.subPoint(pointPrice);
	}
	
	public Resource getResourceRequirement() {
		return resourceRequirement;
	}

	public Resource getResourcePrice() {
		return resourcePrice;
	}

	public Point getPointRequirement() {
		return pointRequirement;
	}

	public Point getPointPrice() {
		return pointPrice;
	}

	public CardType getType() {
		return type;
	}
	
	public int getPeriod(){
		return this.period;
	}
	
	public int getId() {
		return id;
	}

	public Map<CardType, Integer> getRequirementCard() {
		return requirementCard;
	}


	@Override
	public void activeIstantEffect(Player p) throws GameException {
		for(IstantEffect e:this.istantEffect)
			e.activate(p);		
	}
	
	@Override
	public String toString() {
		return "RealCard [name=" + name + ", resourceRequirement=" + resourceRequirement + ", resourcePrice="
				+ resourcePrice + ", pointRequirement=" + pointRequirement + ", pointPrice=" + pointPrice
				+ ", istantEffect=" + istantEffect +", type=" + type + ", id="
				+ id + ", requirementCard=" + requirementCard + "]";
	}


}
