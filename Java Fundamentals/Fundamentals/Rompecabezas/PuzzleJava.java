import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PuzzleJava {
    //Primer Desafio
    public ArrayList<Integer> primero(int[] array) {
        System.out.println("Primer Desafio");
        ArrayList<Integer> retorno = new ArrayList<Integer>();
    	int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
            if (array[i] > 10) {
                retorno.add(array[i]);
            }
        }
        System.out.println(sum);
        return retorno;
    }
    //Segundo Desafio
    public ArrayList<String> segundo(String[] array) {
        System.out.println("Segundo Desafio");
        ArrayList<String> retorno = new ArrayList<String>();
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
            if (array[i].length() > 5) {
                retorno.add(array[i]);
            }
        }
        return retorno;
    }
    //Tercer Desafio
    public void tercer(List<Character> arrayTemp) {
        System.out.println("Tercer Desafio");
        Collections.shuffle(arrayTemp);
        System.out.println(arrayTemp.get(arrayTemp.size()-1));
        System.out.println(arrayTemp.get(0));
        if (arrayTemp.get(0) == 'A' || arrayTemp.get(0) == 'E' || arrayTemp.get(0) == 'I' || arrayTemp.get(0) == 'O' || arrayTemp.get(0) == 'U') {
            System.out.println("Es una Vocal Hurra!!");
        }
    }
    //Cuarto Desafio
    public ArrayList<Integer> cuarto() {
        System.out.println("Cuarto Desafio");
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 10; i++){
        	retorno.add(r.nextInt(100-55)+55);
            
        }
        return retorno;
    }
    //Quinto Desafio
    public ArrayList<Integer> quinto() {
        System.out.println("Quinto Desafio");
        ArrayList<Integer> retorno = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 10; i++){
        	retorno.add(r.nextInt(100-55)+55);
            
        }
        Collections.sort(retorno);
        return retorno;
    }
    //Sexto Desafio
    public String sexto() {
        System.out.println("Sexto Desafio");
        String retorno = "";
        Random r = new Random();
        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for(int i =  0; i < 5; i++){
			retorno += abc[r.nextInt(abc.length)];
		}
        return retorno;
    }
    //Septimo Desafio
    public ArrayList<String> septimo() {
        System.out.println("Septimo Desafio");
        ArrayList<String> retorno = new ArrayList<String>();
        Random r = new Random();
        char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int e = 0;e < 10; e++) {
        	String word = "";
			for(int i =  0; i < 5; i++){
				word += abc[r.nextInt(abc.length)];
			}
			retorno.add(word);
        }
        return retorno;
    }
}