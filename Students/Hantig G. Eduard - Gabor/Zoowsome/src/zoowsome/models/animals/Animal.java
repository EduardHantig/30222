package zoowsome.models.animals;
import java.util.Random;

public abstract class Animal implements Killer {
	private int nrOfLegs;
	private String name;
	private final double maintenanceCost;
	private final double dangerPerc;
	private boolean takenCareOf = false;
	
	
	public Animal (double maintenanceCost, double dangerPerc) {
		this.maintenanceCost = maintenanceCost;
		this.dangerPerc = dangerPerc;
	}
	
	public boolean kill() {
		Random random = new Random();
		if (random.nextDouble() < (this.dangerPerc + getPredisposition())) {
			return true;
		}
		return false;
	}
	
	public double getPredisposition() {
		return 0;
	}
	public int getNrOfLegs() {
		return nrOfLegs;
	}
	
	public void setNrOfLegs(int nrOfLegs) {
		this.nrOfLegs = nrOfLegs;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getMaintenanceCost() {
		return maintenanceCost;
	}

	public double getDangerPerc() {
		return dangerPerc;
	}

	public boolean isTakenCareOf() {
		return takenCareOf;
	}

	public void setTakenCareOf(boolean takenCareOf) {
		this.takenCareOf = takenCareOf;
	}
	
}
