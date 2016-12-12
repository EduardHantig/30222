package zoowsome.models.employees;

import java.math.BigDecimal;

import zoowsome.models.animals.Animal;
import zoowsome.services.factories.animal.Constants;

public class Caretaker extends Employee implements Caretaker_I {
	private double workingHours;
	
	public String takeCareOf(Animal animal) {
		if (animal.kill()) {
			return Constants.Employee.Caretakers.TCO_KILLED;
		}
		if (this.workingHours < animal.getMaintenanceCost()) {
			return Constants.Employee.Caretakers.TCO_NO_TIME;
		}
		animal.setTakenCareOf(true);
		this.workingHours = this.workingHours - animal.getMaintenanceCost();
		
		return Constants.Employee.Caretakers.TCO_SUCCESS;
	}

	public Caretaker(String name, long id, BigDecimal salary, boolean isDead) {
		super(name, id, salary, isDead);
	}
	
	public double getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(double workingHours) {
		this.workingHours = workingHours;
	}

}
