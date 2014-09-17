package chessgame;

import java.util.Map;

import chessgame.enums.EnPassant;
import chessgame.piece.Pawn;
import chessgame.piece.Piece;
import core.Coordinate;

class EnPassantController {
	private Map<Coordinate, Piece> board;
	private RecordBoard recordBoard;

	EnPassantController(Map<Coordinate, Piece> board, RecordBoard recordBoard) {
		this.board = board;
		this.recordBoard = recordBoard;
	}

	void doAboutEnPassantAfterMove(Coordinate movedPawn) {
		int row = movedPawn.getRow();
		int col = movedPawn.getCol();
		Coordinate coordinate;
		
		//check whether it's the first move or not
		if(!((Pawn)board.get(movedPawn)).isFirstMove()) {
			return;
		}
		//check whether there are any pawns on the movedpawn's both side
		coordinate = CoordinateSelector.checkCoordinateException(row, col - 1);
		if(isPossibleEnPassant(coordinate)) {
			recordBoard.addEnPanssant(coordinate, EnPassant.RIGHT);
		}
		coordinate = CoordinateSelector.checkCoordinateException(row, col + 1);
		if(isPossibleEnPassant(coordinate)) {
			recordBoard.addEnPanssant(coordinate, EnPassant.LEFT);
		}
	}

	private boolean isPossibleEnPassant(Coordinate coordinate) {
		return board.containsKey(coordinate) && board.get(coordinate) instanceof Pawn;
	}
}
