package chessgame.piece;

import java.util.Set;

import core.Coordinate;
import chessgame.StatusChecker;
import chessgame.enums.Side;

public class Rook implements Piece {
	Side side;

	public Rook(Side side) {
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
			return "\u265C";
		}
		return "\u2656";
	}

	@Override
	public Set<Coordinate> searchMovibleGrids(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		// TODO Auto-generated method stub
		return null;
	}
}
