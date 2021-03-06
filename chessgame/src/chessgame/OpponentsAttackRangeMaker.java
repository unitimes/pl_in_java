package chessgame;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import chessgame.piece.Piece;
import core.Coordinate;

class OpponentsAttackRangeMaker {

	private OpponentsAttackRangeMaker() {		
	}

	public static Set<Coordinate> makeOpponentsAttackRange(
			Map<Coordinate, Piece> board, RecordBoard recordBoard, StatusChecker statusChecker) {
		Set<Coordinate> opponentsAttackRange = new HashSet<Coordinate>();
		board.forEach((k, v) -> {
			manageOpponentsAttackRange(k, v, recordBoard, statusChecker, opponentsAttackRange);
		});
		return opponentsAttackRange;
	}

	private static void manageOpponentsAttackRange(Coordinate coordinate, Piece piece, RecordBoard recordBoard, StatusChecker statusChecker, Set<Coordinate> opponentsAttackRange) {
		if (!piece.isYourSide(recordBoard.getSide())) {
			addOpponentsAttackRange(piece.searchMovibleGrids(coordinate,
					statusChecker), opponentsAttackRange);
		}
	}

	private static void addOpponentsAttackRange(Set<Coordinate> opponentsMovibleGrids, Set<Coordinate> opponentsAttackRange) {
		if (opponentsMovibleGrids != null) {
			opponentsAttackRange.addAll(opponentsMovibleGrids);
		}
	}
}