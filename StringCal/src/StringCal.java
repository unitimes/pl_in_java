public class StringCal {
	public String[] split(String str) {
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
			System.exit(0);
		}
		return nums;
	}

	int sum(int[] nums) {
		int sum = 0;
		for (int i : nums)
			sum += i;
		return sum;
	}
	
	int add(String str) {
		if (str.isEmpty()) {
			return 0;
		}
		return sum(convert(split(str)));
	}

	public static void main(String[] args) {
		StringCal cal = new StringCal();
		System.out.println(cal.add("1\n3,6"));
	}

}
