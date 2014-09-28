package userInterface;

import chessgame.enums.Side;

class MsgPrinter {
	private MsgPrinter() {
	}
	
	static void printWelcomeMsg() {
		System.out.println("Welcome to Chess World!!");
		System.out
				.print("Enter any key to start a chessgame. Or if you want exit game, please enter 'q': ");
	}

	static void printGoodbyeMsg() {
		System.out.println("This msg will be Exploded in 5 senconds.");
		try {
			for (int i = 1; i <= 5; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Hey, just kidding^^");
			System.out.println("Thank you for playing this game!!");
		}
	}

	static void printStartGameMsg() {
		System.out.println("New Game started!!");
		System.out.println("Always Side 'White' is the first.");
	}

	static void printInformChoicePieceToMove() {
		printInformCommon();
		System.out.print("Choose a grid on where a pice to move is: ");
	}

	static void printInformChoiceTargetToMove() {
		printInformCommon();
		System.out.println("If you want to re-choose a piece to move, enter 'r' or 'R'.");
		System.out
				.print("Choose a grid where the pice you've choosed to move: ");
	}
	
	private static void printInformCommon() {
		System.out
				.println("CAUTION!! Must enter Rank, File in order!! (ex. 5d)");
		System.out.println("If you want exit this game, enter 'q' or 'Q'.");
		System.out.println("If you want play new game, enter 'n' or 'N'.");
	}
	
	static void printInformPromotion() {
		System.out.println("Your pawn has reached the end of rank.");
		System.out.print("Enter wanted piced to promote(q: Queen / k: Knight / r: Rook / b: Bishop): ");
	}
	
	public static void printCheckMate(Side side) {
		String sideForMsg = "white";
		if(side.equals(Side.WHITE)) {
			sideForMsg = "black";
		}
		System.out.println("Checkmated!!");
		System.out.format("Side '%s' win!!\n", sideForMsg);
	}
}
