package chessgame;

import java.util.Map;

import chessgame.enums.Side;
import chessgame.piece.Piece;
import core.Coordinate;

 public class StatusChecker {
	Map<Coordinate, Piece> board;

	StatusChecker(Map<Coordinate, Piece> board) {
		this.board = board;
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

}
