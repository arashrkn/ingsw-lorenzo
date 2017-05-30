package gamemodel;

public class Point 
{
	private int military;
	private int faith;
	private int victory;
	
	public Point(int military,int faith,int victory)
	{
		this.military=military;
		this.faith=faith;
		this.victory=victory;
	}
	
	public int getMilitary()
	{
		return this.military;
	}
	public int getFaith()
	{
		return this.faith;
	}
	public int getVictory()
	{
		return this.victory;
	}
	
	
	public void addPoint(Point p)
	{
		this.military+=p.military;
		this.faith+=p.faith;
		this.victory+=p.victory;
	}
	
	public void subPoint(Point p)
	{
		this.military-=p.military;
		this.faith-=p.faith;
		this.victory-=p.victory;
	}

	public boolean isEnought(Point p) 
	{
			return(this.military>=p.military &&
				this.faith>=p.faith &&
				this.victory>=p.victory);
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + faith;
		result = prime * result + military;
		result = prime * result + victory;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (faith != other.faith)
			return false;
		if (military != other.military)
			return false;
		if (victory != other.victory)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String srt="";
		if(military!=0)
			srt+=" military= "+this.military;
		if(faith!=0)
			srt+=" faith= "+this.faith;
		if(victory!=0)
			srt+=" victory= "+this.victory;
		return srt;
	}
	
}
