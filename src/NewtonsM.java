
public class NewtonsM {
	static double sum = 0.0;
	static double sum2 = 0.0;


	//F(x), this function solves F(X) for x
	public static Complex initFunction(Complex [] a, Complex guess, double degree) {
		Complex ans = new Complex(0,0);
		
		for (int i = 0; i < a.length; ++i) {
			ans = ans.plus(a[i].times(Complex.pow(guess, degree - i))); 
		}
		return ans;
	}

	//This function solves Newton's Method Equation
	public static Complex solve(Complex func, Complex deriv, Complex x){
		Complex val = x.minus(func).divides(deriv);
		return val;
	}
	
	

	//This function calculates synthetic division of an expression and root
	public static Complex syntheticDiv(Complex [] a, Complex root){
	
		Complex temp = new Complex(0,0);
		temp = (root.times(a[0])).plus(a[1]);
		
		for(int i = 2; i < a.length - 1; ++i){
			temp = (root.times(a[i])).plus(a[i+1]);
		}	
		return temp ;
	}

}
