package chessgame.piece;

import java.util.HashSet;
import java.util.Set;

import core.Coordinate;
import chessgame.StatusChecker;
import chessgame.enums.Side;

public class Pawn implements Piece {

	Side side;

	public Pawn(Side side) {
		this.side = side;
	}

	@Override
	public Boolean isYourSide(Side side) {
		return this.side == side;
	}

	@Override
	public Set<Coordinate> searchMovibleGrids(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		if (side == Side.WHITE) {
			return searchMovibleGridsWhenWhite(pieceToMove, statusChecker);
		}
		return searchMovibleGridsWhenBlack(pieceToMove, statusChecker);
	}

	private Set<Coordinate> searchMovibleGridsWhenWhite(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		Set<Coordinate> movibleNodes = new HashSet<>();
		int row = pieceToMove.getRow();
		int col = pieceToMove.getCol();

		if (!statusChecker.isPlaced(new Coordinate(row + 1, col))) {
			movibleNodes.add(new Coordinate(row + 1, col));
		}
		if (statusChecker.isAttackable(new Coordinate(row + 1, col + 1),
				this.side)) {
			movibleNodes.add(new Coordinate(row + 1, col + 1));
		}
		if (statusChecker.isAttackable(new Coordinate(row + 1, col - 1),
				this.side)) {
			movibleNodes.add(new Coordinate(row + 1, col - 1));
		}
		return movibleNodes;
	}

	private Set<Coordinate> searchMovibleGridsWhenBlack(Coordinate pieceToMove,
			StatusChecker statusChecker) {
		Set<Coordinate> movibleNodes = new HashSet<>();
		int row = pieceToMove.getRow();
		int col = pieceToMove.getCol();

		if (!statusChecker.isPlaced(new Coordinate(row - 1, col))) {
			movibleNodes.add(new Coordinate(row - 1, col));
		}
		if (statusChecker.isAttackable(new Coordinate(row - 1, col + 1),
				this.side)) {
			movibleNodes.add(new Coordinate(row - 1, col + 1));
		}
		if (statusChecker.isAttackable(new Coordinate(row + 1, col - 1),
				this.side)) {
			movibleNodes.add(new Coordinate(row - 1, col - 1));
		}
		return movibleNodes;
	}
	@Override
	public String toString() {
		if (side == Side.BLACK) {
			return "\u265F";
		}
		return "\u2659";
	}
}
