public class Number {
	int num;

	Number(int n) {
		this.num = n;
	}

	int add(int n) {
		return num + n;
	}
	int sub(int n) {
		return num - n;
	}
	int mul(int n) {
		return num * n;
	}
	int div(int n) {
		return num / n;
	}

	public static void main(String[] args) {
		int a = 9;
		int b = 4;
		Number num = new Number(a);
		System.out.println("덧셈: " + a + " + " + b + " = "+ num.add(b));
		System.out.println("뺄셈: " + a + " - " + b + " = "+ num.sub(b));
		System.out.println("곱셈: " + a + " * " + b + " = "+ num.mul(b));
		System.out.println("나눗셈: " + a + " / " + b + " = "+ num.div(b));
	}
}
