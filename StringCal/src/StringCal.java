public class StringCal {
	String[] split(String str) {
		if (str.isEmpty()) {
			String[] temp = { "0" };
			return temp;
		}
		return str.split(",|\n");
	}

	int[] convert(String[] str) {
		int[] nums = new int[str.length];
		try {
			for (int i = 0; i < str.length; i++) {
				nums[i] = Integer.parseInt(str[i]);
			}
		} catch (Exception e) {
			System.out.println("숫자와 허가된 기호 이외의 값을 입력 받음");
			int[] temp = {0};
			return temp;
		}
		return nums;
	}

	int add(int[] nums) {
		int n = 0;
		for (int i : nums)
			n += i;
		return n;
	}

	public static void main(String[] args) {
		StringCal cal = new StringCal();
		System.out.println(cal.add(cal.convert(cal.split("1\n3,6"))));
		System.out.println(cal.add(cal.convert(cal.split("1\n3,g"))));
	}

}
