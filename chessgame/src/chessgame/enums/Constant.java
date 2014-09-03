package chessgame.enums;

public enum Constant {
	MAX_ROW(8), MAX_COL(8);
	int number;

	private Constant(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
