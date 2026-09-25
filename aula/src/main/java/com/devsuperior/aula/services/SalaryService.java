package com.devsuperior.aula.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.aula.entities.Employee;

@Service
public class SalaryService {

	@Autowired
	private TaxService taxService;
	@Autowired
	private PensionService pensionService;

	public SalaryService(){
		
	}
	
	public double netSalary(Employee employee) {

		double grossSal = employee.getGrossSalary();
		return grossSal - taxService.tax(grossSal) - pensionService.discount(grossSal);

	}
}
