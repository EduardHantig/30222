package zoowsome.models.animals;

public class Whale extends Aquatic {

	public Whale(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(0);
		setName("Whale");
		super.setWatertype(watertype.Saltwater);
		super.setAvgSwimDepth(1700);
	}
	
	public Whale(int nrOfLegs, String name, watertype type, int avgSwimDepth, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setWatertype(type);
		super.setAvgSwimDepth(avgSwimDepth);
	}
}
