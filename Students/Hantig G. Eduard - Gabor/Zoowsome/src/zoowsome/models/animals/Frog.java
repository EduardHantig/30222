package zoowsome.models.animals;

public class Frog extends Aquatic {

	public Frog(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(4);
		setName("Frog");
		super.setWatertype(watertype.Freshwater);
		super.setAvgSwimDepth(0);
	} 
	
	public Frog(int nrOfLegs, String name, watertype type, int avgSwimDepth, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setWatertype(type);
		super.setAvgSwimDepth(avgSwimDepth);
	}
}
