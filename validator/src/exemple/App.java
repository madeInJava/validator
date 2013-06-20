package exemple;

import br.com.madeInJava.validate.Validator;

public class App {
	public static void main(String[] args) {

		String value = "estaEhUmaValidacaoDe@EMail.com";

		// Validação através de Boolean
		Validator.getEmailValidator().isValid(value);

		// Validação através de exception
		Validator.getEmailValidator().doValidation(value);

		System.out.println("Success!!");
	}
}
