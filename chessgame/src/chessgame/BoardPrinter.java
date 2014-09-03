package chessgame;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import chessgame.enums.Constant;
import chessgame.piece.Piece;
import core.Coordinate;

class BoardPrinter {
	private Map<Coordinate, Piece> board;
	private Set<Coordinate> movibleGrids;

	BoardPrinter(Map<Coordinate, Piece> board) {
		this.board = board;
	}

	BoardPrinter(Map<Coordinate, Piece> board, Set<Coordinate> movibleGrids) {
		this(board);
		this.movibleGrids = movibleGrids;
	}
	
	void printBoard() {
		for (int row = Constant.MAX_ROW.getNumber() - 1; row >= 0; row--) {
			printRow(row);
		}
		movibleGrids = new HashSet<Coordinate>();
	}

	private void printRow(int row) {
		for (int col = 0; col < Constant.MAX_COL.getNumber(); col++) {
			printGrid(new Coordinate(row, col));
		}
		System.out.println();
	}

	private void printGrid(Coordinate grid) {
		if (movibleGrids != null && movibleGrids.contains(grid)) {
			System.out.print("  ");
			return;
		}
		if (board.containsKey(grid)) {
			System.out.print(board.get(grid).toString() + " ");
			return;
		}
		System.out.print("\u254B ");
	}
}
