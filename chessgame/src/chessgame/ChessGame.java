package chessgame;

import java.util.Map;

import chessgame.piece.Piece;
import core.Coordinate;

public class ChessGame {
	private BoardCreator boardCreator;
	private MoveController moveController;
	private BoardPrinter boardPrinter;
	private RecordBoard recordBoard;

	public ChessGame() {
		Map<Coordinate, Piece> board;

		boardCreator = new BoardCreator();
		board = boardCreator.getBoard();
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(board);
		moveController = new MoveController(board, recordBoard, boardPrinter);
	}

	public void choosePieceToMove(Coordinate piece) {
		moveController.printMovibleGridsSet(piece);
	}

	public void moveChoosedPieceTo(Coordinate target) {
		moveController.moveChoosedPieceTo(target);
	}

	public void moveDirectTo(Coordinate priceToMove, Coordinate target) {
		moveController.moveDirectTo(priceToMove, target);
	}
	
	public void printBoard() {
		boardPrinter.printBoard();
	}
	
	public void printRecord() {
		recordBoard.printRecord();
	}
}
