public class StringManipulatorTesting {
    public static void main(String[] args) {
    	//Primer Codigo
        StringManipulator manipulator = new StringManipulator();
		String str = manipulator.trimAndConcat("    Hola     ","     Mundo    ");
		System.out.println(str); // HolaMundo 
		//Segundo Codigo
		char letter = 'n';
		Integer a = manipulator.getIndexOrNull("Coding", letter);
		Integer b = manipulator.getIndexOrNull("Hola Mundo", letter);
		Integer c = manipulator.getIndexOrNull("Saludar", letter);
		System.out.println(a); // 4
		System.out.println(b); // 7
		System.out.println(c); // null
		//Tercer Codigo
		String word = "Hola";
		String subString = "la";
		String notSubString = "mundo";
		Integer d = manipulator.getIndexOrNull(word, subString);
		Integer w = manipulator.getIndexOrNull(word, notSubString);
		System.out.println(d); // 2
		System.out.println(w); // null
		//Cuarto Codigo
		String union = manipulator.concatSubstring("Hola", 1, 2, "mundo");
		System.out.println(union); // omundo
    }
}