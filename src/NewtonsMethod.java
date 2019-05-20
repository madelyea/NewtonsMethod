import java.util.Arrays;
import java.util.Scanner;

public class NewtonsMethod {

	public static void main(String[] args) {
		Complex sum = new Complex(0, 0);
		Complex sum2 = new Complex(0, 0);
		Complex error = new Complex(0, 0);
		double a = 0.0;
		double b = 0.0;
		Complex temp = new Complex(0, 0);
		double degree = 0.0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Enter the degree of the polynomial less than 100: ");
			degree = sc.nextDouble();
		} while (degree > 100);

		System.out.println("Enter an initial guess in the complex form a + bi. a: ");
		a = sc.nextDouble();
		System.out.println("b: ");
		b = sc.nextDouble();

		Complex guess = new Complex(a, b); // Create complex object for guess

		// Create array of function coefficients (stored as complex objects)
		Complex[] coefArray = new Complex[(int) (degree + 1.0)];

		System.out.println("Enter " + (degree + 1) + " complex coefficients: ");
		for (int i = 0; i < coefArray.length; ++i) {
			System.out.print("a" + (i) + ": ");
			a = sc.nextDouble();
			System.out.print(" b: ");
			b = sc.nextDouble();
			Complex coef = new Complex(a, b);
			coefArray[i] = coef;
		}
		//Deriv coeff array
		Complex[] derivArray = new Complex[(int) (degree)];
		for(int i = 0; i < derivArray.length; ++i){
			Complex tempVar = new Complex(coefArray.length-i-1, 0);
		   derivArray[i] = coefArray[i].times(tempVar);
		}
		
		System.out.println(Arrays.toString(coefArray));
		System.out.println(Arrays.toString(derivArray));
		int count = 0;
		
		// Newton's Method
		do {
	
			sum = NewtonsM.initFunction(coefArray, guess, degree);
			sum2 = NewtonsM.initFunction(derivArray, guess, degree - 1);
			
			temp = guess;
			guess = temp.minus(sum.divides(sum2));

			error = guess.minus(temp);
			System.out.println("guess" + guess.toString());
	
		} while (Math.abs(error.re) > 0.001); // The real portion of the imaginary #
	
		
		System.out.println("Root = " + guess.toString());
		
		//Use synthetic division to solve for new root
		Complex function = NewtonsM.syntheticDiv(coefArray, guess);
		Complex derivf = NewtonsM.syntheticDiv(derivArray, guess);
		
	//	Complex root = NewtonsM.solve(function, derivf, guess);
		//root.toString();
	}
}
