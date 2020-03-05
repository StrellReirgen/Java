import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
    	//llamado basico
        PuzzleJava coding = new PuzzleJava();
		//Primer Desafio
		int[] primero = {3,5,1,2,7,9,8,13,25,32};
		ArrayList<Integer> first = coding.primero(primero);
		System.out.println(first);
		// //Segundo Desafio
		String[] segundo = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
		ArrayList<String> second = coding.segundo(segundo);
		System.out.println(second);
		// //Tercer Desafio
		ArrayList<Character> tercer = new ArrayList<Character>();
		char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for(int i =  0; i < abc.length; i++){
			tercer.add(abc[i]);
		}
		coding.tercer(tercer);
		//Cuarto Desafio
		ArrayList<Integer> fourth = coding.cuarto();
		System.out.println(fourth);
		//Quinto Desafio
		ArrayList<Integer> fifth = coding.quinto();
		System.out.println(fifth);
		int max = fifth.get(0);
		int min = fifth.get(0);
	    for (int i = 0;i < fifth.size(); i++){
	    		if (fifth.get(i) > max) {
	    			max = fifth.get(i);
	    		}  
	    		if (fifth.get(i) < min) {
		    		min = fifth.get(i);
		    	} 
	    }
	    System.out.println("El Numero mas Bajo: " + min);
	    System.out.println("El Numero mas Alto: " + max);
		//Sexto Desafio
	    String six = coding.sexto();
	    System.out.println(six);
		//Septimo Desafio
	    ArrayList<String> seven = coding.septimo();
	    System.out.println(seven);
    }
}