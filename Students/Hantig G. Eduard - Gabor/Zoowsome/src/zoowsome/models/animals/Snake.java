package zoowsome.models.animals;

import java.time.LocalTime;

public class Snake extends Reptile {

	public Snake(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(0);
		setName("Snake");
		super.setLaysEggs(true);
	}
	
	public Snake(int nrOfLegs, String name, boolean laysEggs, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setLaysEggs(laysEggs);
	}
	
	public double getPredisposition() {
		LocalTime time = LocalTime.now();
		
		if (time.getHour() > 10 && time.getHour() < 19) {
			return 0.25;
		}
		return 0;
	}
}