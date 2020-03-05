import java.util.ArrayList;

public class Testeo{
    public void testing(){
        ArrayList<Object> myList = new ArrayList<>();
        myList.add("13");
        myList.add("Hola Mundo");
        myList.add(48);
        myList.add("Adios Mundo");
        for(int i=0; i<myList.size(); i++){
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(castedValue);
            } catch(ClassCastException e) {
                System.err.println("ERROR EN INDICE "+i);
            }
        }
    }  
}