package chessgame;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import chessgame.enums.Castling;
import chessgame.enums.Side;
import chessgame.piece.Bishop;
import chessgame.piece.King;
import chessgame.piece.Knight;
import chessgame.piece.Pawn;
import chessgame.piece.Piece;
import chessgame.piece.Queen;
import chessgame.piece.Rook;
import core.Coordinate;

public class MoveControllerTest {
	private Map<Coordinate, Piece> testBoard;
	private MoveController moveController;
	private RecordBoard recordBoard;
	private BoardPrinter boardPrinter;

	@Before
	public void setUp() {
		testBoard = new HashMap<Coordinate, Piece>();
	}

	@Test
	public void testCastlingLong() {
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		boardPrinter.printBoard();
		moveController.castling(Castling.LONG);
		boardPrinter.printBoard();
		recordBoard.changeSide();
		moveController.castling(Castling.LONG);
		boardPrinter.printBoard();
	}

	@Test
	public void testCastlingShort() {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Pawn(Side.WHITE));
		((Pawn)testBoard.get(new Coordinate(3, 2))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(3, 4))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(4, 4))).increaseMoveCount();;
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		boardPrinter.printBoard();
		moveController.castling(Castling.SHORT);
		boardPrinter.printBoard();
		recordBoard.changeSide();
		moveController.castling(Castling.SHORT);
		boardPrinter.printBoard();
	}
	
	@Test
	public void testEnPassantWhenRight() throws Exception {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Pawn(Side.WHITE));
		((Pawn)testBoard.get(new Coordinate(3, 2))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(3, 4))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(4, 4))).increaseMoveCount();;
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		moveController.printMovibleGridsSet(new Coordinate(1, 3));
		moveController.moveChoosedPieceTo(new Coordinate(3, 3));
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(3, 2));
		moveController.moveDirectTo(new Coordinate(3, 2), new Coordinate(2, 3));
		boardPrinter.printBoard();
	}
	
	@Test
	public void testEnPassantWhenRightJustGoFoward() throws Exception {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Pawn(Side.WHITE));
		((Pawn)testBoard.get(new Coordinate(3, 2))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(3, 4))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(4, 4))).increaseMoveCount();;
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		moveController.printMovibleGridsSet(new Coordinate(1, 3));
		moveController.moveChoosedPieceTo(new Coordinate(3, 3));
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(3, 2));
		moveController.moveDirectTo(new Coordinate(3, 2), new Coordinate(2, 2));
		boardPrinter.printBoard();
	}
	
	@Test
	public void testEnPassantWhenLeft() throws Exception {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Pawn(Side.WHITE));
		((Pawn)testBoard.get(new Coordinate(3, 2))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(3, 4))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(4, 4))).increaseMoveCount();;
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		moveController.printMovibleGridsSet(new Coordinate(1, 3));
		moveController.moveChoosedPieceTo(new Coordinate(3, 3));
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(3, 4));
		moveController.moveDirectTo(new Coordinate(3, 4), new Coordinate(2, 3));
		boardPrinter.printBoard();
	}
	
	@Test
	public void testMakeEnPassantSituation() throws Exception {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Pawn(Side.WHITE));
		((Pawn)testBoard.get(new Coordinate(3, 2))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(3, 4))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(4, 4))).increaseMoveCount();;
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		moveController.printMovibleGridsSet(new Coordinate(1, 3));
		moveController.moveChoosedPieceTo(new Coordinate(3, 3));
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(3, 4));
		moveController.moveDirectTo(new Coordinate(6, 5), new Coordinate(4, 5));
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(4, 4));
		moveController.printMovibleGridsSet(new Coordinate(3, 3));
	}
	
	@Test
	public void testKingMove() throws Exception {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Pawn(Side.WHITE));
		((Pawn)testBoard.get(new Coordinate(3, 2))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(3, 4))).increaseMoveCount();;
		((Pawn)testBoard.get(new Coordinate(4, 4))).increaseMoveCount();;
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		moveController.printMovibleGridsSet(new Coordinate(0, 4));
		moveController.moveChoosedPieceTo(new Coordinate(0, 6));
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(7, 4));
		System.out.println(recordBoard.canCastlingShort());
		moveController.moveChoosedPieceTo(new Coordinate(7, 2));
		boardPrinter.printBoard();
	}
	
	@Test
	public void testBlackKingCastling() throws Exception {
		testBoard.put(new Coordinate(0, 6), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 5), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Pawn(Side.WHITE));
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		moveController.printMovibleGridsSet(new Coordinate(0, 5));
		
		recordBoard.changeSide();
		
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(7, 4));
		System.out.println(recordBoard.canCastlingShort());
	}
	
	@Test
	public void testRookMove() throws Exception {
		testBoard.put(new Coordinate(4, 4), new Rook(Side.WHITE));
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		moveController.printMovibleGridsSet(new Coordinate(4, 4));
		
		testBoard.remove(new Coordinate(4, 4));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		moveController.printMovibleGridsSet(new Coordinate(0, 0));
	}
	
	@Test
	public void testRookMoveWhenOtherPieces() throws Exception {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Rook(Side.WHITE));
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		moveController.printMovibleGridsSet(new Coordinate(4, 4));
		
		testBoard.remove(new Coordinate(4, 4));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		moveController.printMovibleGridsSet(new Coordinate(0, 0));
	}
	
	@Test
	public void testBishopMove() throws Exception {
		testBoard.put(new Coordinate(4, 4), new Bishop(Side.WHITE));
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(4, 4));
		
		testBoard.remove(new Coordinate(4, 4));
		testBoard.put(new Coordinate(0, 0), new Bishop(Side.WHITE));
		moveController.printMovibleGridsSet(new Coordinate(0, 0));
	}
	
	@Test
	public void testBishopMoveWhenOtherPieces() throws Exception {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Bishop(Side.WHITE));
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(4, 4));
		
		testBoard.remove(new Coordinate(4, 4));
		testBoard.put(new Coordinate(0, 0), new Bishop(Side.WHITE));
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(0, 0));
	}
	
	@Test
	public void testQueenMove() throws Exception {
		testBoard.put(new Coordinate(4, 4), new Queen(Side.WHITE));
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(4, 4));
		
		testBoard.remove(new Coordinate(4, 4));
		testBoard.put(new Coordinate(0, 0), new Queen(Side.WHITE));
		moveController.printMovibleGridsSet(new Coordinate(0, 0));
	}
	
	@Test
	public void testQueenMoveWhenOtherPieces() throws Exception {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 3), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Queen(Side.WHITE));
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(4, 4));
		
		testBoard.remove(new Coordinate(4, 4));
		testBoard.put(new Coordinate(0, 0), new Queen(Side.WHITE));
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(0, 0));
	}
	
	@Test
	public void testKnightMove() throws Exception {
		testBoard.put(new Coordinate(4, 4), new Knight(Side.WHITE));
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(4, 4));
		
		testBoard.remove(new Coordinate(4, 4));
		testBoard.put(new Coordinate(0, 0), new Knight(Side.WHITE));
		moveController.printMovibleGridsSet(new Coordinate(0, 0));
	}
	
	@Test
	public void testKnightMoveWhenOtherPieces() throws Exception {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(7, 4), new King(Side.BLACK));
		testBoard.put(new Coordinate(7, 7), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(7, 0), new Rook(Side.BLACK));
		testBoard.put(new Coordinate(1, 2), new Pawn(Side.WHITE));
		testBoard.put(new Coordinate(3, 2), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(3, 4), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(6, 5), new Pawn(Side.BLACK));
		testBoard.put(new Coordinate(4, 4), new Knight(Side.WHITE));
		recordBoard = new RecordBoard();
		boardPrinter = new BoardPrinter(testBoard);
		moveController = new MoveController(testBoard, recordBoard, boardPrinter);
		
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(4, 4));
		
		testBoard.remove(new Coordinate(4, 4));
		testBoard.put(new Coordinate(0, 0), new Knight(Side.WHITE));
		boardPrinter.printBoard();
		moveController.printMovibleGridsSet(new Coordinate(0, 0));
	}
}
