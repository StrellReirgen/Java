package calculadora2;

public class calculator2 implements java.io.Serializable{
	private double valor1;
	private double valor2;
	private String operador1;
	private String operador2;
	private double total;
	private boolean valor1Set = false;
	private boolean valor2Set = false;
	private boolean operador1Set = false;
	private boolean operador2Set = false;
	private boolean totalSet = false;
	
	public calculator2() {
	}
	public void performOperation(double valor) {
		if(!this.valor1Set) {
			this.valor1 = valor;
			this.valor1Set = true;
		} else if(operador1Set && !valor2Set) {
			if(this.operador1 == "*") {
				this.valor1 = this.valor1*valor;
				this.operador1Set = false;
			} else if(this.operador1 == "/") {
				this.valor1 = this.valor1/valor;
				this.operador1Set = false;
			} else {
				this.valor2 = valor;
				this.valor2Set = true;
			}
		} else if(operador1Set && valor2Set && operador2Set) {
			if(this.operador2 == "*") {
				this.valor2 = this.valor2*valor;
				this.operador2Set = false;
			} else if(this.operador2 == "/") {
				this.valor2 = this.valor2/valor;
				this.operador2Set = false;
			} else {
				if(this.operador1 == "+") {
					this.valor1 += this.valor2;
				} else {
					this.valor1 -= this.valor2;
				}
				this.operador1 = this.operador2;
				this.operador2Set = false;
				this.valor2 = valor;
			}
		} else {
			throw new IllegalThreadStateException();
		}
	}
	public void performOperation(String operator) {
		if(operator == "=") {
			if(!this.valor2Set) {
				this.total = this.valor1;
			} else if(this.operador1 == "+") {
				this.total = this.valor1 + this.valor2;
			} else if(this.operador1 == "-"){
				this.total = this.valor1 - this.valor2;
			} else {
				throw new IllegalThreadStateException();
			}
			totalSet = true;
		} else if(operator == "*" || operator == "/" || operator == "+" || operator == "-") {
			totalSet = false;
			if(this.valor1Set && !this.operador1Set) {
				this.operador1 = operator;
				this.operador1Set = true;
			} else if(this.valor1Set && this.operador1Set && this.valor2Set && !this.operador2Set) {
				this.operador2 = operator;
				this.operador2Set = true;
			} else {
				throw new IllegalThreadStateException();
			}
		} else {
			throw new UnsupportedOperationException();
		}
	}
	public void getResults() {
		if(totalSet == true) {
			System.out.println(this.total);
		} else {
			throw new IllegalThreadStateException();
		}
	}
}
