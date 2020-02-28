import java.lang.Math;
public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
    	double val = legA + legB;
    	double squareRoot = Math.sqrt(val);
    	return squareRoot;
    }
}