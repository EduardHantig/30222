package zoowsome.models.animals;

public class Monkey extends Mammal {

	public Monkey(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(4);
		setName("Monkey");
		super.setNormalBodyTemp((float)37);
		super.setPercBodyHair(79);
	}
	
	public Monkey(int nrOfLegs, String name, float normalBodyTemp, int percBodyHair, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setNormalBodyTemp(normalBodyTemp);
		super.setPercBodyHair(percBodyHair);
	}
	
}