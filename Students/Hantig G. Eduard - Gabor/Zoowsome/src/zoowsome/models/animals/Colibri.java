package zoowsome.models.animals;

public class Colibri extends Bird {

	public Colibri(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(2);
		setName("Colibri");
		super.setMigrates(false);
		super.setAvgFlightAltitude(15);
	}
	
	public Colibri(int nrOfLegs, String name, boolean migrates, int avgFlightAltitude, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setMigrates(migrates);
		super.setAvgFlightAltitude(avgFlightAltitude);
	}
}