package br.com.madeInJava.validator.validators;

import java.util.ArrayList;
import java.util.List;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.cpf.CPFCharSetException;
import br.com.madeInJava.validator.exceptions.cpf.InvalidCPFException;
import br.com.madeInJava.validator.exceptions.cpf.LenghtException;
import br.com.madeInJava.validator.model.Patterns;

public class CPFValidator extends AbstractValidator<String> {

	private final int[] weight = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	private List<String> notValidSet;
	private PatternValidator numberValidator;

	public CPFValidator() {
		notValidSet = new ArrayList<String>();
		notValidSet.add("00000000000");
		notValidSet.add("11111111111");
		notValidSet.add("22222222222");
		notValidSet.add("33333333333");
		notValidSet.add("44444444444");
		notValidSet.add("55555555555");
		notValidSet.add("66666666666");
		notValidSet.add("77777777777");
		notValidSet.add("88888888888");
		notValidSet.add("99999999999");
		numberValidator = new PatternValidator(Patterns.INTEGER.getPattern());
	}

	private int calculateDigitValue(String base) {
		int sum = 0;
		for (int i = base.length() - 1, digit; i >= 0; i--) {
			digit = Integer.parseInt(base.substring(i, i + 1));
			sum += digit * this.weight[this.weight.length - base.length() + i];
		}
		sum = 11 - sum % 11;
		return sum > 9 ? 0 : sum;
	}

	@Override
	protected void validate(String cpf) {
		if (cpf.length() != 11 && cpf.length() != 14) {
			throw new LenghtException();
		}

		if (cpf.length() == 14) {
			cpf = cpf.replaceAll("[.-]", "");
		}

		this.numberValidator.doValidation(cpf);
		
		if (this.notValidSet.contains(cpf)) {
			throw new CPFCharSetException();
		}

		Integer digit1 = calculateDigitValue(cpf.substring(0, 9));
		Integer digit2 = calculateDigitValue(cpf.substring(0, 9) + digit1);

		if (!cpf.equals(cpf.substring(0, 9) + digit1.toString() + digit2.toString())) {
			throw new InvalidCPFException();
		}
	}
}
