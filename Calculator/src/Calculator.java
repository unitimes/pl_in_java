
public class Calculator {
	int add(int i, int j) {
		return i + j;
	}
	int test(String str) {
		return Integer.parseInt(str);
	}
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		System.out.println(cal.test("a"));
	}
}