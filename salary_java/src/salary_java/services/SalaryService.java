package salary_java.services;

import salary_java.entities.Employee;

public class SalaryService {

	TaxService taxService = new TaxService();
	PensionService pensionService = new PensionService();

	public double netSalary(Employee employee) {

		double grossSal = employee.getGrossSalary();
		return grossSal - taxService.tax(grossSal) - pensionService.discount(grossSal);

	}
}
