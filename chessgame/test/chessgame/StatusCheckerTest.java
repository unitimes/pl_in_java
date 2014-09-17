package chessgame;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import chessgame.enums.Castling;
import chessgame.enums.Side;
import chessgame.piece.King;
import chessgame.piece.Pawn;
import chessgame.piece.Piece;
import chessgame.piece.Rook;
import core.Coordinate;

public class StatusCheckerTest {
	private Map<Coordinate, Piece> testBoard;
	private StatusChecker statusChecker;
	private RecordBoard recordBoard;

	@Before
	public void setUp() {
		testBoard = new HashMap<Coordinate, Piece>();
	}
	
	@Test
	public void testIsKingSideEmpty() {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		
		recordBoard = new RecordBoard();
		statusChecker = new StatusChecker(testBoard, recordBoard);
		assertTrue(statusChecker.isCastlingSpaceEmpty(Castling.SHORT));
		
		testBoard.put(new Coordinate(0, 5), new Pawn(Side.WHITE));
		assertFalse(statusChecker.isCastlingSpaceEmpty(Castling.SHORT));
	}

	@Test
	public void testIsKingSideEmptyWhenOn6() {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		
		recordBoard = new RecordBoard();
		statusChecker = new StatusChecker(testBoard, recordBoard);
		assertTrue(statusChecker.isCastlingSpaceEmpty(Castling.SHORT));
		
		testBoard.put(new Coordinate(0, 6), new Pawn(Side.WHITE));
		assertFalse(statusChecker.isCastlingSpaceEmpty(Castling.SHORT));
	}
	
	@Test
	public void testIsQueenSideEmpty() {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		testBoard.put(new Coordinate(0, 0), new Rook(Side.WHITE));
		
		recordBoard = new RecordBoard();
		statusChecker = new StatusChecker(testBoard, recordBoard);
		assertTrue(statusChecker.isCastlingSpaceEmpty(Castling.LONG));
		
		testBoard.put(new Coordinate(0, 1), new Pawn(Side.WHITE));
		assertTrue(statusChecker.isCastlingSpaceEmpty(Castling.LONG));
	}
	
	@Test
	public void testIsQueenSideEmptyWhenOn3() {
		testBoard.put(new Coordinate(0, 4), new King(Side.WHITE));
		testBoard.put(new Coordinate(0, 7), new Rook(Side.WHITE));
		
		recordBoard = new RecordBoard();
		statusChecker = new StatusChecker(testBoard, recordBoard);
		assertTrue(statusChecker.isCastlingSpaceEmpty(Castling.LONG));
		
		testBoard.put(new Coordinate(0, 3), new Pawn(Side.WHITE));
		assertFalse(statusChecker.isCastlingSpaceEmpty(Castling.LONG));
	}
}
