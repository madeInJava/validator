package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.general.ModelNotFoundException;
import br.com.madeInJava.validator.exceptions.general.NotEqualsException;

/**
 * @author Renan JP
 * @version 1.0.0
 * @param <T>
 *            Tipagem dinâmica
 */
public class EqualsValidator<T> extends AbstractValidator<T> {

	private T model;

	public EqualsValidator() {
		super();
	}

	public EqualsValidator(T model) {
		this();
		this.model = model;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	/**
	 * Método responsável por validar a igualdade entre o modelo previamente
	 * definido e o parametro em questão;
	 * 
	 * @param value
	 *            Tipagem dinâmica. Valor a ser validado;
	 * 
	 * @exception ModelNotFoundException
	 *                Exceção lançada quando o modelo não é definido previamente
	 *                a invocação deste método. Para definir o modelo utilize os
	 *                métodos de acesso (getModel e setModel) ou o construtor
	 *                parametrizado;
	 * @exception NotEqualsException
	 *                Exceção lançada quando o parâmetro não é igual ao modelo
	 *                previamente definido;
	 */
	@Override
	protected void validate(T value) {
		if (model == null) {
			throw new ModelNotFoundException();
		}

		if (!model.equals(value)) {
			throw new NotEqualsException();
		}
	}

}
