package chessgame;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import chessgame.enums.Side;
import chessgame.piece.King;
import chessgame.piece.Pawn;
import chessgame.piece.Piece;
import chessgame.piece.Queen;
import userInterface.UserInterface;
import core.Coordinate;

public class ChessGameTest {
	private ChessGame chessGame;

	@Before
	public void setUp() {
		chessGame = new ChessGame();
	}

	@Test
	// (expected=IllegalArgumentException.class)
	public void testMove() {
		chessGame.printBoard();
		chessGame.choosePieceToMove(new Coordinate(1, 2));
		chessGame.printBoard();
		chessGame.moveChoosedPieceTo(new Coordinate(3, 2));
		chessGame.printBoard();
		chessGame.choosePieceToMove(new Coordinate(6, 1));
		chessGame.printBoard();
		chessGame.moveChoosedPieceTo(new Coordinate(5, 1));
		chessGame.printBoard();
		chessGame.choosePieceToMove(new Coordinate(3, 2));
		chessGame.printBoard();
		chessGame.moveChoosedPieceTo(new Coordinate(4, 2));
		chessGame.printBoard();
		chessGame.choosePieceToMove(new Coordinate(5, 1));
		chessGame.printBoard();
		chessGame.moveChoosedPieceTo(new Coordinate(4, 1));
		chessGame.printBoard();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoveExceptionWhenChooseNonMovibleGrid() {
		chessGame.choosePieceToMove(new Coordinate(1, 1));
		chessGame.moveChoosedPieceTo(new Coordinate(3, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoveExceptionWhenChooseNotYourPiece() {
		chessGame.printBoard();
		chessGame.choosePieceToMove(new Coordinate(6, 1));
	}

	@Test
	public void testPrintRecord() throws Exception {
		chessGame.printBoard();
		chessGame.printRecord();
	}

	@Test
	public void testRecordAfterAttack() throws Exception {
		chessGame.moveDirectTo(new Coordinate(1, 1), new Coordinate(2, 2));
		chessGame.printBoard();
		chessGame.printRecord();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPromotePawn() throws Exception {
		Class<?> targetClass = chessGame.getClass();
		Class[] cArg = new Class[1];
		Object[] oArg = new Object[1];
		cArg[0] = String.class;
		oArg[0] = null;
		Method selectPiece = targetClass.getDeclaredMethod("selectPiece", cArg);
		selectPiece.setAccessible(true);
		System.out.println(selectPiece.invoke(chessGame, oArg));
		
		Map<Coordinate, Piece> testBoard = new HashMap<Coordinate, Piece>();
		testBoard.put(new Coordinate(6, 4), new Pawn(Side.WHITE));

		chessGame = new ChessGame(testBoard);
		chessGame.printBoard();
		chessGame.printRecord();
		
		assertFalse(chessGame.isPossiblePromotion());
		
		chessGame.choosePieceToMove(new Coordinate(6, 4));
		chessGame.moveChoosedPieceTo(new Coordinate(7, 4));
		
		assertTrue(chessGame.isPossiblePromotion());
		chessGame.printBoard();
		
		chessGame.promotePawn("z");
		chessGame.printBoard();
		chessGame.printRecord();
		assertFalse(chessGame.isPossiblePromotion());
	}
	
	@Test
	public void testCheckmate() throws Exception {
		Map<Coordinate, Piece> testBoard = new HashMap<Coordinate, Piece>();
		testBoard.put(new Coordinate(7, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(3, 6), new Queen(Side.BLACK));

		chessGame = new ChessGame(testBoard);
		chessGame.printBoard();
		chessGame.printRecord();
		
		chessGame.moveDirectTo(new Coordinate(7, 4), new Coordinate(6, 4));
		chessGame.moveDirectTo(new Coordinate(3, 6), new Coordinate(4, 6));
		chessGame.printBoard();
		chessGame.printRecord();
		
		assertTrue(chessGame.isCheckmate());
	}
}
