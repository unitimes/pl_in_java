
public class NonStaticCal {
	int add(int a, int b) {
		return a + b;
	}
	int sub(int a, int b) {
		return a - b;
	}
	int mul(int a, int b) {
		return a * b;
	}
	int div(int a, int b) {
		return a / b;
	}
	public static void main(String[] args) {
		int a = 9;
		int b = 4;
		NonStaticCal cal = new NonStaticCal();
		System.out.println("Addition: " + a + " + " + b + " = " + cal.add(a, b));
		System.out.println("Subtraction: " + a + " - " + b + " = " + cal.sub(a, b));
		System.out.println("Multiply: " + a + " * " + b + " = " + cal.mul(a, b));
		System.out.println("Divide: " + a + " / " + b + " = " + cal.div(a, b));
	}
}
