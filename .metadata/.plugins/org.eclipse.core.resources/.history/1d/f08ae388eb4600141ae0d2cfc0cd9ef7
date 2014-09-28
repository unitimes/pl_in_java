package chessgame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import core.Coordinate;
import chessgame.enums.Castling;
import chessgame.enums.EnPassant;
import chessgame.enums.Side;
import chessgame.piece.Piece;

class RecordBoard {
	private Map<Integer, Piece> deadPiecesOfBlack;
	private Map<Integer, Piece> deadPiecesOfWhite;
	private Map<Coordinate, EnPassant> possibleEnPassants;
	private Set<Castling> castlingPossibilitySet;
	private int turn;
	private Side side;

	RecordBoard() {
		this.deadPiecesOfBlack = new HashMap<Integer, Piece>();
		this.deadPiecesOfWhite = new HashMap<Integer, Piece>();
		this.possibleEnPassants = new HashMap<Coordinate, EnPassant>();
		this.castlingPossibilitySet = new HashSet<Castling>();
		this.turn = 1;
		this.side = Side.WHITE;
	}

	void goNextTurn() {
		this.turn++;
	}

	void changeSide() {
		resetCastlingPossibilitySet();
		if (isWhite()) {
			this.side = Side.BLACK;
			return;
		}
		this.side = Side.WHITE;
		goNextTurn();
	}

	Side getSide() {
		return this.side;
	}

	void recordDeadPiece(Piece deadPiece) {
		if (isWhite()) {
			deadPiecesOfWhite.put(turn, deadPiece);
			return;
		}
		deadPiecesOfBlack.put(turn, deadPiece);
	}

	boolean isWhite() {
		return this.side == Side.WHITE;
	}

	boolean isBlack() {
		return this.side == Side.BLACK;
	}

	void printRecord() {
		System.out.format("Turn: %d\n", this.turn);
		System.out.format("Side: %s", side);
		deadPiecesOfBlack.values().forEach(p -> {
			System.out.print(p.toString() + " ");
		});
		System.out.println();
		deadPiecesOfWhite.values().forEach(p -> {
			System.out.print(p.toString() + " ");
		});
		System.out.println();
		System.out.println(castlingPossibilitySet.toString());
	}

	// ---------------about EnPassant-----------------------//
	void addEnPanssant(Coordinate pawn, EnPassant direction) {
		possibleEnPassants.put(pawn, direction);
	}

	void resetPossibleEnPassants() {
		possibleEnPassants.clear();
	}

	boolean isPossibleEnPassant(Coordinate pawn) {
		return possibleEnPassants.containsKey(pawn);
	}

	EnPassant getEnPassantDirection(Coordinate pawn) {
		return possibleEnPassants.get(pawn);
	}

	// ---------------End of about EnPassant-----------------------//

	// ------------------ about castling-------------------------//
	void addCastlingPossibility(Castling type) {
		this.castlingPossibilitySet.add(type);
	}

	void resetCastlingPossibilitySet() {
		castlingPossibilitySet = new HashSet<Castling>();
	}

	boolean canCastlingLong() {
		return castlingPossibilitySet.contains(Castling.LONG);
	}

	boolean canCastlingShort() {
		return castlingPossibilitySet.contains(Castling.SHORT);
	}
	// ---------------End of about castling----------------//
}
