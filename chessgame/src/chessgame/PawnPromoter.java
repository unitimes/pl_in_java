package chessgame;

import java.util.Map;

import chessgame.piece.Piece;
import core.Coordinate;

class PawnPromoter {
	private PawnPromoter() {
	}
	
	static void promotePawn (Map<Coordinate, Piece> board, RecordBoard recordBoard, Piece type) {
		Coordinate targetGrid = recordBoard.getPromotionTarget();
		board.remove(targetGrid);
		board.put(targetGrid, type);
	}
}
