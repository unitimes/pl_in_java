package chessgame;

import core.Coordinate;
import chessgame.enums.Castling;
import chessgame.enums.Side;

public class CoordinateSelector {

	private CoordinateSelector() {
	}

	static public int productFirstRank(RecordBoard recordBoard) {
		if (recordBoard.isBlack()) {
			return 7;
		}
		return 0;
	}
	
	static public int productCastlingTargetColOfKing(Castling type) {
		if (type == Castling.LONG) {
			return 2;
		}
		return 6;
	}
	
	static public int productCastlingColOfRook(Castling type) {
		if (type == Castling.LONG) {
			return 0;
		}
		return 7;
	}
	
	static public int productCastlingTargetColOfRook(Castling type) {
		if (type == Castling.LONG) {
			return 3;
		}
		return 5;
	}
	
	static public int productRowIncrementOfPawn(RecordBoard recordBoard) {
		if (recordBoard.isBlack()) {
			return -1;
		}
		return 1;
	}
	
	static public int productRowIncrementOfPawn(Side side) {
		if (side == Side.BLACK) {
			return -1;
		}
		return 1;
	}
	
	static public int productRowOfEnPassant(RecordBoard recordBoard) {
		if (recordBoard.isBlack()) {
			return 3;
		}
		return 4;
	}
	
	static public Coordinate checkCoordinateException(int row, int col) {
		try {
			return new Coordinate(row, col);
		} catch (IllegalArgumentException e) {
			//System.err.format("IllegalArgumentException: %s%n", e.getMessage());
			return null;
		}
	}
}
