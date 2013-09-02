package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.general.ModelNotFoundException;
import br.com.madeinjava.validator.exceptions.general.NotEqualsException;

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
	 * @exception InvalidArgumentException
	 *                Exceção lancada quando o parâmetro é inválido. Exemplo:
	 *                Valor nulo;
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
		if (value == null) {
			throw new InvalidArgumentException();
		} else if (model == null) {
			throw new ModelNotFoundException();
		} else if (!model.equals(value)) {
			throw new NotEqualsException();
		}
	}

}
