public class Main {
    public static void main(String[] args) {
    	//llamado basico
        BasicJava coding = new BasicJava();
		//Primer Desafio
		coding.printer(255);
		//Segundo Desafio
		coding.printerOdd(255);
		//Tercer Desafio
		coding.printerSum(255);
		//Cuarto Desafio
		int[] cuarto = {1,3,5,7,9,13};
		coding.printerArray(cuarto);
		//Quinto Desafio
		int[] quinto = {-3,-5,-7};
		coding.printerMax(quinto);
		//Sexto Desafio
		int[] sexto = {2,10,3};
		coding.printerAverage(sexto);
		//Septimo Desafio
		coding.printerArrayOdd(255);
		//Octavo Desafio
		int[] octavo = {1,3,5,7};
		coding.printerMaxY(octavo,3);
		//Noveno Desafio
		int[] noveno = {1,5,10,-2};
		coding.printerSquare(noveno);
		//Decimo Desafio
		int[] decimo = {1,5,10,-2};
		coding.printerNoNegativo(decimo);
		//Undecimo Desafio
		int[] undecimo = {1,5,10,-2};
		coding.printerMinMaxAvrg(undecimo);
		//Duodecimo Desafio
		int[] duodecimo = {1,5,10,7,-2};
		coding.printerFinal(duodecimo);
    }
}