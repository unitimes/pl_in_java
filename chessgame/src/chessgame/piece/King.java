package chessgame.piece;

import java.util.Set;

import chessgame.StatusChecker;
import chessgame.enums.Side;
import core.Coordinate;

public class King implements Piece {
	Side side;

	public King(Side side) {
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
			return "\u265A";
		}
		return "\u2654";
	}

	@Override
	public Set<Coordinate> searchMovibleGrids(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		// TODO Auto-generated method stub
		return null;
	}
}