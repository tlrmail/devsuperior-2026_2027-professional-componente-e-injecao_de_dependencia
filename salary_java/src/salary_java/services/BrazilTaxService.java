package salary_java.services;

public class BrazilTaxService implements TaxService {

	@Override
	public double tax(double amount) {
		return amount * 0.3;
	}

}
