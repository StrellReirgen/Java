package cuentabanco;

public class BancoTest {

	public static void main(String[] args) {
		BankAccount cuenta = new BankAccount();
		BankAccount cuenta1 = new BankAccount();
		BankAccount cuenta2 = new BankAccount();
		BankAccount cuenta3 = new BankAccount();
		cuenta.datos();
		cuenta.deposito("corriente", 100);
		cuenta.deposito("algo", 500);
		cuenta.deposito("ahorro", 1000);
		cuenta.retirar("corriente", 50);
		cuenta.retirar("ayuda", 42);
		cuenta.retirar("ahorro", 300);
		cuenta.retirar("ahorro", 1000000);
		cuenta.getBalances();
	}
}
