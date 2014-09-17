package chessgame.piece;

import java.util.HashSet;
import java.util.Set;

import chessgame.CoordinateSelector;
import chessgame.StatusChecker;
import chessgame.enums.Side;
import core.Coordinate;

public class King implements Piece {

	private CompositeCommon compositePieceCommon;
	private CompositeMoveCount compositeMoveCount;

	public King(Side side) {
		this.compositePieceCommon = new CompositeCommon(side);
		this.compositeMoveCount = new CompositeMoveCount();
	}

	@Override
	public Boolean isYourSide(Side side) {
		return compositePieceCommon.isYourSide(side);
	}

	@Override
	public String toString() {
		if (isYourSide(Side.BLACK)) {
			return "\u265A";
		}
		return "\u2654";
	}

	@Override
	public Set<Coordinate> searchMovibleGrids(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		Set<Coordinate> movibleGrids = new HashSet<>();
		int row = pieceToMove.getRow();
		int col = pieceToMove.getCol();
		
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row + 1, col));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row + 1, col + 1));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row + 1, col - 1));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row, col + 1));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row, col - 1));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row - 1, col));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row - 1, col + 1));
		addMovibleGrid(movibleGrids, statusChecker, CoordinateSelector.checkCoordinateException(row - 1, col - 1));
		
		movibleGrids.remove(null);
		return movibleGrids;
	}

	private Boolean addMovibleGrid(Set<Coordinate> movibleGrids, StatusChecker statusChecker, Coordinate grid) {
		return compositePieceCommon.addMovibleGrid(movibleGrids, statusChecker, grid);
	}

	public Boolean isFirstMove() {
		return compositeMoveCount.isFirstMove();
	}

	public void increaseMoveCount() {
		compositeMoveCount.increaseMoveCount();
	}
}
