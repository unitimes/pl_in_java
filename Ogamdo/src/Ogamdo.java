
public class Ogamdo {
	public static void main(String[] args) {
		System.out.println("오감도 - 이상");
		System.out.println("13인의 아해가 도로로 질주하오.");
		System.out.println("(길은 막다른 골목길이 적당하오.)\n");
		for(int i = 1; i < 14; i++) {
			if(i == 11)
				System.out.println();
			System.out.format("제%d의 아해가 무섭다고 그리오.\n", i);
		}
		System.out.println("13인의 아해는 무서운 아해와 무서워하는 아해와 그렇게 뿐이 모였소.");
		System.out.println("(다른 사정은 없는 것이 차라리 나았소)\n");
		for(int i = 1; i < 3; i++) {
			System.out.format("그중에 %d인의 아해가 무서운 아해라도 좋소.\n", i);
		}
		for(int i = 2; i > 0; i--) {
			System.out.format("그중에 %d인의 아해가 무서워하는 아해라도 좋소.\n", i);
		}
		System.out.println("(길은 뚫린 골목이라도 적당하오.)\n");
		System.out.println("13인의 아해가 도로로 질주하니 아니 하여도 좋소.");
	}
}
