public class SimpleCalculator {
	static int add(int a, int b) {
		return a + b;
	}

	static int sub(int a, int b) {
		return a - b;
	}

	static int mul(int a, int b) {
		return a * b;
	}

	static int div(int a, int b) {
		return a / b;
	}

	public static void main(String[] args) {
		int a = 9;
		int b = 4;
		System.out.println("Addition: " + a + " + " + b + " = "
				+ SimpleCalculator.add(a, b));
		System.out.println("Subtraction: " + a + " - " + b + " = "
				+ SimpleCalculator.sub(a, b));
		System.out.println("Multiply: " + a + " * " + b + " = "
				+ SimpleCalculator.mul(a, b));
		System.out.println("Divide: " + a + " / " + b + " = "
				+ SimpleCalculator.div(a, b));
		System.out.println();
	}
}