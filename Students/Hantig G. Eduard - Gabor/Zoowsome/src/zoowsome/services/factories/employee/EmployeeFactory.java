package zoowsome.services.factories.employee;

import zoowsome.services.factories.animal.Constants;

public class EmployeeFactory {

	public TypeEmployeeFactory getTypeEmployeeFactory(String type) throws Exception {
		if(Constants.TypeOfEmployees.CARETAKER.equals(type)) {
			return new CaretakerFactory();
		} else {
			throw new Exception("Invalid Species Exception!");
		}
		
	}
}
