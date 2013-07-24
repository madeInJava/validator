package br.com.madeinjava.validator;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * Classe base para os validadores;
 * <p>
 * Esta classe implementa dois padrões de projeto, <a
 * href="http://pt.wikipedia.org/wiki/Chain_of_Responsibility" >Chain Of
 * Responsibility</a> e <a
 * href="http://pt.wikipedia.org/wiki/Template_Method">Template Method</a>.
 * Através deles é possível a criação e associação de validadores;
 * </p>
 * 
 * @author Renan JP
 * @version 1.0.0
 * @param <T>
 *            Tipagem dinâmica;
 */
public abstract class AbstractValidator<T> {

	private AbstractValidator<T> nexValidator;

	/**
	 * Método responsável pelo encadeamento de validadores;
	 * 
	 * @param validator
	 *            Tipagem dinâmica;
	 */
	public void setNextValidator(AbstractValidator<T> validator) {
		this.nexValidator = validator;
	}

	public AbstractValidator<T> getNExtValidator() {
		return this.nexValidator;
	}
	
	/**
	 * Método responsável por propagar a validação dentre a cadeia de
	 * validadores;
	 * 
	 * @exception ValidateException
	 *                Exceção lançada quando é encontrada uma não conformidade.
	 *                Esta exceção pode ser estendida;
	 * @param value
	 *            Tipagem dinâmica. Valor a ser validado;
	 */
	public void doValidation(T value) {
		this.validate(value);

		if (this.nexValidator != null) {
			this.nexValidator.doValidation(value);
		}
	}

	/**
	 * Método responsável por validar um determinado valor;
	 * <p>
	 * Este método utiliza o método {@link AbstractValidator#doValidation(T)};
	 * </p>
	 * 
	 * @param value
	 *            Tipagem dinâmica. Valor a ser validado;
	 * @return <b>true</b> para valores válidos e <b>false</b> para valores
	 *         inválidos;
	 */
	public boolean isValid(T value) {
		try {
			this.doValidation(value);
			return true;
		} catch (ValidateException e) {
			return false;
		}
	}

	/**
	 * Método template para a validação de valores;
	 * <p>
	 * Para que a validação funcione, é necessário lançar exceções baseadas em
	 * {@link ValidateException} assim que uma não conformidade for encontrada;
	 * </p>
	 * 
	 * @param value
	 *            Tipagem dinâmica. Valor a ser validado;
	 */
	protected abstract void validate(T value);
}
