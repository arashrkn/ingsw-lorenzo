package gamemodel.card;

import java.util.HashMap;
import java.util.Map;

import gamemodel.CardType;
import gamemodel.Player;
import gamemodel.Point;
import gamemodel.Resource;

public class RealCard implements Card {
		
	private Resource resourceRequirement;
	private Resource resourcePrice;
	private Point pointRequirement;
	private Point pointPrice;
	private CardType type;
	private final int id;
	private static int identifier=0;
	private Map<CardType,Integer> requirementCard=new HashMap<>();
		

	public boolean ControlResource(Player p){
		if(resourceRequirement!=null)
			return p.isEnoughtResource(resourceRequirement);
		if(pointRequirement!=null)
			return p.isEnoughtPoint(pointRequirement);
		if(!requirementCard.isEmpty())
			return(requirementCard.get(CardType.BUILDINGS)>=p.countCard(CardType.BUILDINGS)) 
					&&(requirementCard.get(CardType.CHARACTERS)>=p.countCard(CardType.CHARACTERS))
					&&(requirementCard.get(CardType.VENTURES)>=p.countCard(CardType.VENTURES))
					&&(requirementCard.get(CardType.TERRITORIES)>=p.countCard(CardType.TERRITORIES));
		return true;
							
		
	}

	@Override
	public void pay(Player p){
		if(resourcePrice!=null)
			p.subResources(resourcePrice);	
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
	
	public int getId() {
		return id;
	}

	public Map<CardType, Integer> getRequirementCard() {
		return requirementCard;
	}

	public RealCard(Resource resourceRequirement, Resource resourcePrice, Point point, 
			Point pointPrice, CardType type,Map<CardType, Integer> requirementCard) {
		this.id=identifier;
		identifier++;
		this.resourceRequirement = resourceRequirement;
		this.resourcePrice = resourcePrice;
		this.pointRequirement = point;
		this.pointPrice = pointPrice;
		this.type = type;
		this.requirementCard = requirementCard;
	}

}
