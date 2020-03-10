package cuentabanco;

import java.text.DecimalFormat;

public class BankAccount {
	DecimalFormat df = new DecimalFormat("#.00");
	private String numeroCuenta;
	private double saldoCorriente;
	private double saldoAhorro;
	private static int contadorCuentas = 0;
	private static double montoTotal = 0;
	
	public BankAccount() {
		contadorCuentas++;
		this.numeroCuenta = creandoNumero();
	}
	public String creandoNumero() {
		String numeroCuenta = "";
		for(int i=0; i<10; i++) {
			int random = (int) (Math.random()*10);
			numeroCuenta += random;
		}
		return numeroCuenta;
	}
	private double getSaldoCorriente() {
		return this.saldoCorriente;
	}
	private double getSaldoAhorro() {
		return this.saldoAhorro;
	}
	
	public void datos() {
		System.out.println("Numero de Cuentas: " + contadorCuentas);
		System.out.println("Cuenta Actual: "+ numeroCuenta);
	}
	public void getBalances() {
		System.out.println("Cuenta Corriente: $"+df.format(getSaldoCorriente()));
		System.out.println("Cuenta Ahorro: $"+df.format(getSaldoAhorro()));
	}
	public void deposito(String tipo, double monto) {
		boolean depositado = false;
		if(tipo == "corriente") {
			this.saldoCorriente += monto;
			depositado = true;
		} else if(tipo == "ahorro") {
			this.saldoAhorro += monto;
			depositado = true;
		} else {
			System.out.println("Por favor, escriba una de las dos cuentas a la que depositar: 'corriente' o 'ahorro'.");
		}
		if (depositado) {
			montoTotal += monto;
			System.out.println("Depositado $" + df.format(monto) + " en tu cuenta " + tipo + ".");
		}
	}
	public void retirar(String tipo, double monto) {
		boolean retirado = false;
		if(tipo == "corriente") {
			if(monto > this.saldoCorriente) {
				System.out.println("Fondos Insuficientes.");
			}
			else {
				this.saldoCorriente -= monto;
				retirado = true;
			}
		} else if(tipo == "ahorro") {
			if(monto > this.saldoAhorro) {
				System.out.println("Fondos Insuficientes.");
			}
			else {
				this.saldoAhorro -= monto;
				retirado = true;
			}
		} else {
			System.out.println("Por favor, escriba una de las dos cuentas a la cual va a retirar: 'corriente' o 'ahorro'.");
		}
		if (retirado) {
			montoTotal -= monto;
			System.out.println("retirado $" + df.format(monto) + " desde tu cuenta " + tipo + ".");
		}
	}
}
