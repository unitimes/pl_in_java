package chessgame.piece;

import java.util.Set;

import core.Coordinate;
import chessgame.StatusChecker;
import chessgame.enums.Side;

class CompositeCommon {
	Side side;

	CompositeCommon(Side side) {
		this.side = side;
	}
	
	Boolean isYourSide(Side side) {
		return this.side == side;
	}
	
	Side getSide() {
		return this.side;
	}
	
	Boolean addMovibleGrid(Set<Coordinate> movibleGrids, StatusChecker statusChecker, Coordinate grid) {
		if (statusChecker.isPlaced(grid) && !statusChecker.isAttackable(grid, side)) {
			return false;
		}
		if (statusChecker.isAttackable(grid, side)) {
			movibleGrids.add(grid);
			return false;
		}
		movibleGrids.add(grid);
		return true;
	}
}
