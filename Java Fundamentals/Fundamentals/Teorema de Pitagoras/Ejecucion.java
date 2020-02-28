public class Ejecucion {
    public static void main(String[] args) {
        Pythagorean iD = new Pythagorean();
        double resultado = iD.calculateHypotenuse(6,4);
        System.out.println("La hipotenusa es: " + resultado);
    }
}