package chessgame;

import java.util.HashMap;
import java.util.Map;

import chessgame.enums.Constant;
import chessgame.enums.Side;
import chessgame.piece.Bishop;
import chessgame.piece.King;
import chessgame.piece.Knight;
import chessgame.piece.Pawn;
import chessgame.piece.Piece;
import chessgame.piece.Queen;
import chessgame.piece.Rook;
import core.Coordinate;

public class BoardCreator {
	Map<Coordinate, Piece> board;

	public BoardCreator() {
		board = new HashMap<Coordinate, Piece>();
		setGrids();
	}

	private void setGrids() {
		board.put(new Coordinate(2, 2), new Pawn(Side.BLACK));
		board.put(new Coordinate(2, 0), new Pawn(Side.WHITE));
		setFirstRow(Side.BLACK);
		setFirstRow(Side.WHITE);
		setSecondRow(Side.BLACK);
		setSecondRow(Side.WHITE);
	}

	private void setFirstRow(Side side) {
		int row = 0;
		int col = 0;
		if (side == Side.BLACK) {
			row = Constant.MAX_ROW.getNumber() - 1;
		}
		board.put(new Coordinate(row, col++), new Rook(side));
		board.put(new Coordinate(row, col++), new Knight(side));
		board.put(new Coordinate(row, col++), new Bishop(side));
		board.put(new Coordinate(row, col++), new Queen(side));
		board.put(new Coordinate(row, col++), new King(side));
		board.put(new Coordinate(row, col++), new Bishop(side));
		board.put(new Coordinate(row, col++), new Knight(side));
		board.put(new Coordinate(row, col), new Rook(side));
	}

	private void setSecondRow(Side side) {
		int row = 1;
		if (side == Side.BLACK) {
			row = Constant.MAX_ROW.getNumber() - 2;
		}
		for (int col = 0; col < Constant.MAX_COL.getNumber(); col++) {
			board.put(new Coordinate(row, col), new Pawn(side));
		}
	}

	public Map<Coordinate, Piece> getBoard() {
		return this.board;
	}
}
