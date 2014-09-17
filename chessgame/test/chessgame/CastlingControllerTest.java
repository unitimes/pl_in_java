package chessgame;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import chessgame.enums.Side;
import chessgame.piece.King;
import chessgame.piece.Pawn;
import chessgame.piece.Piece;
import chessgame.piece.Rook;
import core.Coordinate;

public class CastlingControllerTest {
	private Map<Coordinate, Piece> testBoard;
	private StatusChecker statusChecker;
	private RecordBoard recordBoard;
	private CastlingController castlingController;
	private BoardPrinter boardPrinter;

	@Before
	public void setUp() {
		testBoard = new HashMap<Coordinate, Piece>();
	}

	@Test
	public void testCastlingController() {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));

		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		statusChecker = new StatusChecker(testBoard, recordBoard);
		castlingController = new CastlingController(testBoard, statusChecker,
				recordBoard);

		boardPrinter.printBoard();
		recordBoard.printRecord();

		castlingController.checkCastling();
		recordBoard.printRecord();
	}

	@Test
	public void testCastlingControllerWhenUnderAttack() {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));

		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		statusChecker = new StatusChecker(testBoard, recordBoard);
		castlingController = new CastlingController(testBoard, statusChecker,
				recordBoard);
		testBoard.put(new Coordinate(1, 5), new Pawn(Side.BLACK));
		boardPrinter.printBoard();

		castlingController.checkCastling();
		recordBoard.printRecord();
	}
	
	@Test
	public void testCastlingControllerWhenKingUnderAttack() {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		statusChecker = new StatusChecker(testBoard, recordBoard);
		castlingController = new CastlingController(testBoard, statusChecker,
				recordBoard);
		testBoard.put(new Coordinate(1, 4), new Pawn(Side.BLACK));
		boardPrinter.printBoard();
		
		castlingController.checkCastling();
		recordBoard.printRecord();
	}

}
