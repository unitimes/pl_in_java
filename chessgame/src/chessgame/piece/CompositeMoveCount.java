package chessgame.piece;

class CompositeMoveCount {

	private int moveCount;

	CompositeMoveCount() {
		this.moveCount = 0;
	}

	Boolean isFirstMove() {
		return moveCount == 0;
	}

	void increaseMoveCount() {
		moveCount++;
	}
}
