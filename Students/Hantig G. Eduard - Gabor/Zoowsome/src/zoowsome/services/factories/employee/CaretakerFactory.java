package zoowsome.services.factories.employee;

import zoowsome.models.employees.Caretaker;
import zoowsome.models.employees.Employee;
import zoowsome.services.factories.animal.Constants;

import java.math.BigDecimal;
import java.util.Random;

public class CaretakerFactory extends TypeEmployeeFactory{
	
	public Employee getEmployeeFactory(String type) throws Exception {
		if (Constants.TypeOfEmployees.CARETAKER.equals(type)) {
			Random random = new Random();
			int index = random.nextInt(Constants.Numbers.NR_OF_CARETAKERS);
			long id = random.nextLong();
			
			BigDecimal salary = new BigDecimal(1 + random.nextInt(Constants.Numbers.MAX_SALARY));
			Caretaker caretaker =  new Caretaker(Constants.Employee.Caretakers.NAME[index], id, salary, false);
			caretaker.setWorkingHours(Constants.Numbers.MAX_WORKING_HOURS);
			
			return caretaker;
			
		} else {
			throw new Exception("Invalid animal exception!");
		}
	}
}
