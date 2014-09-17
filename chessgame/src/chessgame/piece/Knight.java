package chessgame.piece;

import java.util.HashSet;
import java.util.Set;

import chessgame.CoordinateSelector;
import chessgame.StatusChecker;
import chessgame.enums.Side;
import core.Coordinate;

public class Knight implements Piece {
	CompositeCommon compositePieceCommon;

	public Knight(Side side) {
		compositePieceCommon = new CompositeCommon(side);
	}

	@Override
	public Boolean isYourSide(Side side) {
		return compositePieceCommon.isYourSide(side);
	}
	
	@Override
	public String toString() {
		if (compositePieceCommon.isYourSide(Side.BLACK)) {
			return "\u265E";
		}
		return "\u2658";
	}

	@Override
	public Set<Coordinate> searchMovibleGrids(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		Set<Coordinate> movibleGrids = new HashSet<>();
		int row = pieceToMove.getRow();
		int col = pieceToMove.getCol();
		
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row + 2, col + 1));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row + 2, col - 1));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row - 2, col + 1));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row - 2, col - 1));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row + 1, col + 2));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row - 1, col + 2));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row + 1, col - 2));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row - 1, col - 2));
		
		movibleGrids.remove(null);
		return movibleGrids;
	}
	
	private Boolean addMovibleGrid(Set<Coordinate> movibleGrids,
			StatusChecker statusChecker, Coordinate grid) {
		return compositePieceCommon.addMovibleGrid(movibleGrids, statusChecker,
				grid);
	}
}
