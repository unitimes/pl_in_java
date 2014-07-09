
public class StringCal {
	String[] split(String str) {		
		if(str.isEmpty()) {
			String[] temp = {"0"};
			return temp;
		}
		return str.split(",|\n");
	}
	
	int[] convert(String[] str) {
		int[] nums = new int[str.length];
		for(int i = 0; i < str.length; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		return nums;
	}
	
	int add(int[] nums) {
		int n = 0;
		for(int i : nums)
			n += i;
		return n;
	}
	public static void main(String[] args) {
		StringCal cal = new StringCal();
		System.out.println(cal.add(cal.convert(cal.split(""))));
	}

}
