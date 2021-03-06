package chessgame.piece;

import java.util.HashSet;
import java.util.Set;

import chessgame.StatusChecker;
import chessgame.enums.Constant;
import chessgame.enums.Side;
import core.Coordinate;

public class Queen implements Piece {
	CompositeCommon compositePieceCommon;

	public Queen(Side side) {
		compositePieceCommon = new CompositeCommon(side);
	}

	@Override
	public Boolean isYourSide(Side side) {
		return compositePieceCommon.isYourSide(side);
	}

	@Override
	public String toString() {
		if (compositePieceCommon.isYourSide(Side.BLACK)) {
			return "\u265B";
		}
		return "\u2655";
	}

	@Override
	public Set<Coordinate> searchMovibleGrids(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		Set<Coordinate> movibleGrids = new HashSet<>();
		int row = pieceToMove.getRow();
		int col = pieceToMove.getCol();
		Boolean flag = true;
		
		for (int i = row + 1, j = col + 1; i < Constant.MAX_ROW.getNumber()
				&& j < Constant.MAX_COL.getNumber() && flag; i++, j++) {
			addMovibleGrid(movibleGrids, statusChecker, new Coordinate(i, j));
		}
		flag = true;
		for (int i = row - 1, j = col + 1; i >= 0
				&& j < Constant.MAX_COL.getNumber() && flag; i--, j++) {
			addMovibleGrid(movibleGrids, statusChecker, new Coordinate(i, j));
		}
		flag = true;
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 && flag; i--, j--) {
			addMovibleGrid(movibleGrids, statusChecker, new Coordinate(i, j));
		}
		flag = true;
		for (int i = row + 1, j = col - 1; i < Constant.MAX_ROW.getNumber()
				&& j >= 0 && flag; i++, j--) {
			addMovibleGrid(movibleGrids, statusChecker, new Coordinate(i, j));
		}
		flag = true;
		for (int i = row + 1; i < Constant.MAX_ROW.getNumber() && flag; i++) {
			flag = addMovibleGrid(movibleGrids, statusChecker, new Coordinate(i, col));
		}
		flag = true;
		for (int i = col + 1; i < Constant.MAX_COL.getNumber() && flag; i++) {
			flag = addMovibleGrid(movibleGrids, statusChecker, new Coordinate(row, i));
		}
		flag = true;
		for (int i = row - 1; i >= 0 && flag; i--) {
			flag = addMovibleGrid(movibleGrids, statusChecker, new Coordinate(i, col));
		}
		flag = true;
		for (int i = col - 1; i >= 0 && flag; i--) {
			flag = addMovibleGrid(movibleGrids, statusChecker, new Coordinate(row, i));
		}
		return movibleGrids;
	}

	private Boolean addMovibleGrid(Set<Coordinate> movibleGrids,
			StatusChecker statusChecker, Coordinate grid) {
		return compositePieceCommon.addMovibleGrid(movibleGrids, statusChecker,
				grid);
	}
}
