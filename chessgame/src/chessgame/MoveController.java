package chessgame;

import java.util.Map;
import java.util.Set;

import chessgame.piece.Piece;
import core.Coordinate;

class MoveController {
	private Map<Coordinate, Piece> board;
	private Set<Coordinate> movibleGrids;
	private Coordinate lastChoosedPiece;
	private RecordBoard recordBoard;

	MoveController(Map<Coordinate, Piece> board, RecordBoard recordBoard) {
		this.board = board;
		this.recordBoard = recordBoard;
	}

	void moveChoosedPieceTo(Coordinate target) {
		if (lastChoosedPiece == null) {
			throw new IllegalArgumentException(
					"You've not yet choosen any pieces.");
		}
		if (movibleGrids == null || !movibleGrids.contains(target)) {
			throw new IllegalArgumentException("It's not a movible coordinate.");
		}

		// Attack code
		if (board.containsKey(target)) {
			attackTo(target);
		}

		board.put(target, board.get(lastChoosedPiece));
		board.remove(lastChoosedPiece);
		// Reset
		lastChoosedPiece = null;
		movibleGrids = null;

		recordBoard.changeSide();
	}

	void moveDirectTo(Coordinate pieceToMove, Coordinate target) {
		makeMovibleGridsSet(pieceToMove);
		moveChoosedPieceTo(target);
	}

	private void attackTo(Coordinate target) {
		recordBoard.recordDeadPiece(board.get(target));
		board.remove(target);
	}

	void printMovibleGridsSet(Coordinate piece) {
		makeMovibleGridsSet(piece);
		new BoardPrinter(board, movibleGrids).printBoard();
	}

	private void makeMovibleGridsSet(Coordinate piece) {
		if (!board.containsKey(piece)) {
			throw new IllegalArgumentException("There aren't any pieces.");
		}
		if (!board.get(piece).isYourSide(recordBoard.getSide())) {
			throw new IllegalArgumentException("It's not your piece.");
		}
		lastChoosedPiece = piece;
		movibleGrids = searchMovibleGrids(piece);
	}

	private Set<Coordinate> searchMovibleGrids(Coordinate piece) {
		return board.get(piece).searchMovibleGrids(piece,
				new StatusChecker(board));
	}
}
