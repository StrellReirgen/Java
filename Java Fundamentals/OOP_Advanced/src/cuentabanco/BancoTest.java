package cuentabanco;

public class BancoTest {

	public static void main(String[] args) {
		BankAccount account = new BankAccount();
		account.deposit("checking", 100);
		account.deposit("savings", 1000);
		account.withdraw("checking", 25);
		account.getBalances();

	}

}
