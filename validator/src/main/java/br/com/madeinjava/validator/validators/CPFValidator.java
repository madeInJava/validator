package br.com.madeinjava.validator.validators;

import java.util.ArrayList;
import java.util.List;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.cpf.CPFCharSetException;
import br.com.madeinjava.validator.exceptions.cpf.InvalidCPFException;
import br.com.madeinjava.validator.exceptions.cpf.LenghtException;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.model.Patterns;

/**
 * CPFValidator.
 *
 * @author Renan JP
 * @version 1.0.0
 */
public class CPFValidator extends AbstractValidator<String> {

	/** A constante WEIGHT. */
	private static final int[] WEIGHT = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

	/** A constante CPF_LENGTH. */
	private static final int CPF_LENGTH = 11;

	/** A constante CPF_WITH_MASK_LENGTH. */
	private static final int CPF_WITH_MASK_LENGTH = 14;

	/** A constante CPF_WITHOUT_CHECKED_NUMBER_LENGTH. */
	private static final int CPF_WITHOUT_CHECKED_NUMBER_LENGTH = 9;

	/** not valid set. */
	private List<String> notValidSet;

	/** number validator. */
	private PatternValidator numberValidator;

	/**
	 * Instancia um novo cPF validator.
	 */
	public CPFValidator() {
		this.notValidSet = new ArrayList<String>();
		this.notValidSet.add("00000000000");
		this.notValidSet.add("11111111111");
		this.notValidSet.add("22222222222");
		this.notValidSet.add("33333333333");
		this.notValidSet.add("44444444444");
		this.notValidSet.add("55555555555");
		this.notValidSet.add("66666666666");
		this.notValidSet.add("77777777777");
		this.notValidSet.add("88888888888");
		this.notValidSet.add("99999999999");
		this.numberValidator = new PatternValidator(Patterns.INTEGER.getPattern());
	}

	/**
	 * Calculate digit value.
	 *
	 * @param base base
	 * @return int
	 */
	private int calculateDigitValue(String base) {
		int sum = 0;
		for (int i = base.length() - 1, digit; i >= 0; i--) {
			digit = Integer.parseInt(base.substring(i, i + 1));
			sum += digit * WEIGHT[(WEIGHT.length - base.length()) + i];
		}
		sum = CPF_LENGTH - (sum % CPF_LENGTH);
		return sum > CPF_WITHOUT_CHECKED_NUMBER_LENGTH ? 0 : sum;
	}

	/**
	 * Validate length.
	 *
	 * @param cpf cpf
	 */
	private void validateLength(String cpf) {
		if ((cpf.length() != CPF_LENGTH) && (cpf.length() != CPF_WITH_MASK_LENGTH)) {
			throw new LenghtException();
		}
	}

	/**
	 * Contain mask.
	 *
	 * @param cpf cpf
	 * @return true, se bem sucedido
	 */
	private boolean containMask(String cpf) {
		return cpf.length() == CPF_WITH_MASK_LENGTH;
	}

	/**
	 * Removes the mask.
	 *
	 * @param cpf cpf
	 * @return string
	 */
	private String removeMask(String cpf) {
		return cpf.replaceAll("[.-]", "");
	}

	/**
	 * Método responsável por validar se o parâmetro em questão é um CPF;
	 * <p>
	 * Este método utiliza o validador {@link PatternValidator};
	 * </p>.
	 *
	 * @param cpf cpf
	 */
	@Override
	protected void validate(String cpf) {
		if (cpf == null) {
			throw new InvalidArgumentException();
		} else {
			this.validateLength(cpf);

			String cpfNumber = this.containMask(cpf) ? this.removeMask(cpf) : cpf;

			this.numberValidator.doValidation(cpfNumber);

			if (this.notValidSet.contains(cpfNumber)) {
				throw new CPFCharSetException();
			}

			String cpfWithoutCheckedNumber = cpfNumber.substring(0, CPF_WITHOUT_CHECKED_NUMBER_LENGTH);
			int checkedDigit1 = this.calculateDigitValue(cpfWithoutCheckedNumber);
			int checkedDigit2 = this.calculateDigitValue(cpfWithoutCheckedNumber + checkedDigit1);

			if (!cpfNumber.equals(cpfWithoutCheckedNumber + checkedDigit1 + checkedDigit2)) {
				throw new InvalidCPFException();
			}
		}
	}

}
