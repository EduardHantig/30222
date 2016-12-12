package zoowsome.models.animals;

public class Ostrich extends Bird {

	public Ostrich(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(2);
		setName("Ostrich");
		super.setMigrates(false);
		super.setAvgFlightAltitude(0);
	}
	
	public Ostrich(int nrOfLegs, String name, boolean migrates, int avgFlightAltitude, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setMigrates(migrates);
		super.setAvgFlightAltitude(avgFlightAltitude);
	}
}