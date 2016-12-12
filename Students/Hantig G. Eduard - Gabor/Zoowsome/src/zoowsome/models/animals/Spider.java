package zoowsome.models.animals;

import java.time.LocalTime;

public class Spider extends Insect {

	public Spider(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(8);
		setName("Spider");
		super.setCanFly(false);
		super.setDangerous(false);
	}
	
	public Spider(int nrOfLegs, String name, boolean canFly, boolean isDangerous, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setCanFly(canFly);
		super.setDangerous(isDangerous);
	}
	public double getPredisposition() {
		LocalTime time = LocalTime.now();
		
		// This is the case when we want to verify if time is between 10 P.M. and 5 A.M.
		// If other time is requested in time.plusHours(...) we have to put as parameter the following:
		// 24- first-time in 24h format + second-time in 24h format.(In our example: 24 - 22 + 5
		if (time.getHour() > 22 && time.plusHours(24-22+5).getHour() < 5) {
			return 0.25;
		}
		return 0;
	}
}