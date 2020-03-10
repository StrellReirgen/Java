package calculadora;

public class Calculator implements java.io.Serializable{
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;
	
	public Calculator() {
	}
	
	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		if(operation == "+" || operation == "-") {
			this.operation = operation;
		}
		else {
			System.err.println("Operacion Invalida");
		}
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public void performOperation() {
		if(getOperation() == "+") {
			this.result = getOperandOne()+getOperandTwo();
		} else if(getOperation() == "-") {
			this.result = getOperandOne()-getOperandTwo();
		} else {
			System.err.println("Invalido");
		}
	}
	
	public void getResult() {
		System.out.println(this.result);
	}
}

