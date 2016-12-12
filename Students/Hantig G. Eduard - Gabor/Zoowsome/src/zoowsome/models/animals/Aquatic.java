package zoowsome.models.animals;

public abstract class Aquatic extends Animal {
	private int avgSwimDepth;
	public enum watertype {Saltwater, Freshwater}
	private watertype type;
	
	public Aquatic(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
	}
	
	public int getAvgSwimDepth() {
		return avgSwimDepth;
	}
	
	public void setAvgSwimDepth(int avgSwimDepth) {
		this.avgSwimDepth = avgSwimDepth;
	}

	public watertype getWatertype() {
		return type;
	}

	public void setWatertype(watertype type) {
		this.type = type;
	}	
}
