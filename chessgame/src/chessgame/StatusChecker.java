package chessgame;

import java.util.Map;

import chessgame.enums.Castling;
import chessgame.enums.Constant;
import chessgame.enums.Side;
import chessgame.piece.Piece;
import core.Coordinate;

public class StatusChecker {
	private Map<Coordinate, Piece> board;
	private RecordBoard recordBoard;

	StatusChecker(Map<Coordinate, Piece> board, RecordBoard recordBoard) {
		this.board = board;
		this.recordBoard = recordBoard;
	}

	public Boolean isPlaced(Coordinate grid) {
		return board.containsKey(grid);
	}

	public Boolean isMySide(Coordinate grid, Side side) {
		return board.get(grid).isYourSide(side);
	}

	public Boolean isAttackable(Coordinate grid, Side side) {
		return isPlaced(grid) && !isMySide(grid, side);
	}

	public Boolean isAttackable(Coordinate grid) {
		return isAttackable(grid, recordBoard.getSide());
	}

	// -------------About Castling----------------------//
	public Boolean isCastlingSpaceEmpty(Castling type) {
		int row = CoordinateSelector.productFirstRank(recordBoard);
		if (type == Castling.SHORT) {
			return isKingSideEmpty(row);
		}
		return isQueenSideEmpty(row);
	}

	private Boolean isKingSideEmpty(int row) {
		Boolean result = true;
		for (int i = 5; i < Constant.MAX_COL.getNumber() - 1; i++) {
			result = result & !isPlaced(new Coordinate(row, i));
		}
		return result;
	}

	private Boolean isQueenSideEmpty(int row) {
		Boolean result = true;
		for (int i = 3; i > 1; i--) {
			result = result & !isPlaced(new Coordinate(row, i));
		}
		return result;
	}

	public Boolean isCastlingTarget(Coordinate target, Castling type) {
		if (target.equals(new Coordinate(CoordinateSelector
				.productFirstRank(recordBoard), CoordinateSelector
				.productCastlingTargetColOfKing(type)))) {
			return true;
		}
		return false;
	}
	// -------------End of About Castling----------------------//
}
