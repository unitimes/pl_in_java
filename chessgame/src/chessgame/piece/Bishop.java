package chessgame.piece;

import java.util.Set;

import chessgame.StatusChecker;
import chessgame.enums.Side;
import core.Coordinate;

public class Bishop implements Piece {
	Side side;

	public Bishop(Side side) {
		this.side = side;
	}

	@Override
	public Boolean isYourSide(Side side) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		if (side == Side.BLACK) {
			return "\u265D";
		}
		return "\u2657";
	}

	@Override
	public Set<Coordinate> searchMovibleGrids(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		// TODO Auto-generated method stub
		return null;
	}
}
