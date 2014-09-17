package chessgame.piece;

import java.util.HashSet;
import java.util.Set;

import core.Coordinate;
import chessgame.CoordinateSelector;
import chessgame.StatusChecker;
import chessgame.enums.Side;

public class Pawn implements Piece {

	private CompositeCommon compositePieceCommon;
	private CompositeMoveCount compositeMoveCount;

	public Pawn(Side side) {
		this.compositePieceCommon = new CompositeCommon(side);
		this.compositeMoveCount = new CompositeMoveCount();
	}

	@Override
	public Boolean isYourSide(Side side) {
		return compositePieceCommon.isYourSide(side);
	}

	@Override
	public Set<Coordinate> searchMovibleGrids(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		Set<Coordinate> movibleGrids = new HashSet<>();
		int row = pieceToMove.getRow();
		int col = pieceToMove.getCol();
		Side side = compositePieceCommon.getSide();
		Coordinate coordinate;

		coordinate = CoordinateSelector.checkCoordinateException(row + 1
				* CoordinateSelector.productRowIncrementOfPawn(side), col);
		if (!statusChecker.isPlaced(coordinate)) {
			movibleGrids.add(coordinate);
		}
		if (isFirstMove()
				&& !statusChecker.isPlaced(coordinate)
				&& !statusChecker
						.isPlaced(coordinate = CoordinateSelector.checkCoordinateException(
								row
										+ 2
										* CoordinateSelector
												.productRowIncrementOfPawn(side),
								col))) {
			movibleGrids.add(coordinate);
		}
		addAttackableGrid(movibleGrids, statusChecker,
				CoordinateSelector.checkCoordinateException(row + 1
						* CoordinateSelector.productRowIncrementOfPawn(side),
						col + 1));
		addAttackableGrid(movibleGrids, statusChecker,
				CoordinateSelector.checkCoordinateException(row + 1
						* CoordinateSelector.productRowIncrementOfPawn(side),
						col - 1));
		movibleGrids.remove(null);
		return movibleGrids;
	}

	private void addAttackableGrid(Set<Coordinate> movibleNodes,
			StatusChecker statusChecker, Coordinate grid) {
		if (statusChecker.isAttackable(grid, compositePieceCommon.getSide())) {
			movibleNodes.add(grid);
		}
	}

	@Override
	public String toString() {
		if (compositePieceCommon.isYourSide(Side.BLACK)) {
			return "\u265F";
		}
		return "\u2659";
	}

	public Boolean isFirstMove() {
		return compositeMoveCount.isFirstMove();
	}

	public void increaseMoveCount() {
		compositeMoveCount.increaseMoveCount();
	}
}
