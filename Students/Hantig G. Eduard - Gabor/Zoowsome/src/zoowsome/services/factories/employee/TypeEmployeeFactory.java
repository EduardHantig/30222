package zoowsome.services.factories.employee;

import zoowsome.models.employees.Employee;

public abstract class TypeEmployeeFactory {
	public abstract Employee getEmployeeFactory(String type) throws Exception;
}
