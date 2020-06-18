package calculadora2;

public class calculator2Test {

	public static void main(String[] args) {
		calculator2 calculadora = new calculator2();
		calculadora.performOperation(10.5);
		calculadora.performOperation("+");
		calculadora.performOperation(5.2);
		calculadora.performOperation("*");
		calculadora.performOperation(10);
		calculadora.performOperation("=");
		calculadora.getResults();
	}
}