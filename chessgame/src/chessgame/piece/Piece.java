package chessgame.piece;

import java.util.Set;

import core.Coordinate;
import chessgame.StatusChecker;
import chessgame.enums.Side;

public interface Piece {
	Boolean isYourSide(Side side);

	Set<Coordinate> searchMovibleGrids(Coordinate pieceToMove,
			StatusChecker statusChecker);
}
