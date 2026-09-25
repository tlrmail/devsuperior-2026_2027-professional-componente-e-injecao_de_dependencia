package salary_java.app;

import java.util.Locale;
import java.util.Scanner;

import salary_java.entities.Employee;
import salary_java.services.BrazilTaxService;
import salary_java.services.PensionService;
import salary_java.services.SalaryService;
import salary_java.services.TaxService;

public class Program {
	
	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Nome: ");
		String name = sc.nextLine();
		System.out.print("Salário bruto: ");
		double grossSalary = sc.nextDouble();
		
		Employee employee = new Employee(name, grossSalary);

		TaxService taxService = new BrazilTaxService();
		PensionService pensionService = new PensionService();
		SalaryService salaryService = new SalaryService(taxService, pensionService);
		double netSalary = salaryService.netSalary(employee);

		System.out.printf("Salário líquido: %.2f%n", netSalary);
		
		sc.close();
	}

}
