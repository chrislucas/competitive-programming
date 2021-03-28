package tests.math;

public class FloatPointOp {
	private static double epsilon = 0.00001;
	
	// return a == b ? true : a-b < 0.0D ? (0.0D - (a-b)) < epsilon : a-b < epsilon;
	static boolean almostEquals(double a, double b) {
		return a == b ? true : Math.abs(a-b) < epsilon;
	}
	static boolean greaterThan(double a, double b) {
		return a-b >= epsilon;
	}
	static boolean lessThan(double a, double b) {
		return a-b < epsilon;
	}

	
	public static void main(String[] args) {
		//System.out.println(almostEquals(22.0/7.0, math.PI));
		double[] numbers = {
			1.101/101.0, 1.1/101.0, 1.00000000000001, 1.00000000000002
		};
		
		System.out.println(numbers[0] == numbers[1]);
		System.out.println(almostEquals(numbers[0], numbers[1]));
		
		System.out.println(numbers[0] >= numbers[1]);
		System.out.println(greaterThan(numbers[0], numbers[1]));
		
		System.out.println(1.00000000000001 == 1.00000000000002);
		System.out.println(almostEquals(1.00000000000001, 1.00000000000002));

	
	}
}
