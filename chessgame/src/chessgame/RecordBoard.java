package chessgame;

import java.util.HashMap;
import java.util.Map;

import chessgame.enums.Side;
import chessgame.piece.Piece;

class RecordBoard {
	private Map<Integer, Piece> deadPiecesOfBlack;
	private Map<Integer, Piece> deadPiecesOfWhite;
	private int turn;
	private Side side;
	
	RecordBoard() {
		deadPiecesOfBlack = new HashMap<Integer, Piece>();
		deadPiecesOfWhite = new HashMap<Integer, Piece>();
		turn = 1;
		side = Side.WHITE;
	}
	
	void goNextTurn() {
		turn++;
	}
	
	void changeSide() {
		if(isWhite()) {
			this.side = Side.BLACK;
			return;
		}
		goNextTurn();
		this.side = Side.WHITE;
	}
	
	void recordDeadPiece(Piece deadPiece) {
		if(isWhite()) {
			deadPiecesOfWhite.put(turn, deadPiece);
			return;
		}
		deadPiecesOfBlack.put(turn, deadPiece);
	}

	Side getSide() {
		return this.side;
	}
	
	void printRecord() {
		System.out.format("Turn: %d\n", this.turn);
		System.out.format("Side: %s", side);
		deadPiecesOfBlack.values().forEach(p -> {System.out.print(p.toString() + " ");});
		System.out.println();
		deadPiecesOfWhite.values().forEach(p -> {System.out.print(p.toString() + " ");});
		System.out.println();
	}

	private boolean isWhite() {
		return this.side == Side.WHITE;
	}
}
