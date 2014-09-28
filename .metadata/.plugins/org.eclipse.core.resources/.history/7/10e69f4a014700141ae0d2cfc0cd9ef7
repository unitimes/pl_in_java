package chessgame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
}
