import java.util.ArrayList;
import java.util.Random;

public class Ladder {
	private Node[][] lad;
	private int cols, rows;
	private final int wRows = 12;
	private ArrayList<Integer> prvSelectedRows;

	public Ladder(int cols, int rows) {
		this.cols = cols;
		this.rows = rows;
		lad = new Node[cols][12];
		prvSelectedRows = new ArrayList<Integer>();
		for (int i = cols - 1; i >= 0; i--) {
			setUpCols(i);
		}
		makeLadder();
	}

	public void printLadder() {
		for (int i = 1; i <= cols; i++) {
			System.out.format("%d  ", i);
		}
		System.out.println();
		for (int i = 0; i < wRows; i++) {
			printRow(i);
			System.out.println();
		}
		for (int i = 1; i <= cols; i++) {
			System.out.format("%d  ", i);
		}
		System.out.println();
	}

	public int start(int num) {
		return lad[num - 1][0].go().getPos_x() + 1;
	}

	private void setUpCols(int col) {
		for (int i = wRows - 1; i >= 0; i--) {
			setUpNodes(col, i);
		}
	}

	private void setUpNodes(int col, int row) {
		lad[col][row] = new Node();
		lad[col][row].setPos_x(col);
		lad[col][row].setPos_y(row);
		if (row < wRows - 1)
			lad[col][row].setD_node(lad[col][row + 1]);
	}

	// 나머지가 있을 경우 좌로부터 row를 하나씩 추가하기 위해 rests--를 매개변수로
	private void makeLadder() {
		int rowsPerCols = rows / (cols - 1);
		int rests = rows % (cols - 1);
		for (int i = 0; i < cols - 1; i++) {
			makeLink(i, rowsPerCols, rests--);
		}
	}

	// 나머지가 있을 경우 row를 하나 더
	private void makeLink(int numOfCol, int rowPerCols, int rests) {
		if (rests > 0) {
			rowPerCols++;
		}
		linkCols(numOfCol, rowPerCols);
	}

	// link 2 nodes
	private void linkNodes(Node l, Node r) {
		l.setR_node(r);
		r.setL_node(l);
	}

	// link 2 columns
	private void linkCols(int numOfCol, int numOfRows) {
		ArrayList<Integer> rowList = new ArrayList<Integer>();
		for (int i = 1; i < wRows - 1; i++) {
			buildRowList(rowList, i);
			// rowList.add(i);
		}
		prvSelectedRows = new ArrayList<Integer>();
		Random rdm = new Random();
		// link nodes randomly without duplication
		for (int i = 0; i < numOfRows; i++) {
			int row = rdm.nextInt(rowList.size());
			prvSelectedRows.add(rowList.get(row));
			linkNodes(lad[numOfCol][rowList.get(row)],
					lad[numOfCol + 1][rowList.get(row)]);
			rowList.remove(row);
		}
	}

	private void buildRowList(ArrayList<Integer> list, int row) {
		if (!prvSelectedRows.contains(row))
			list.add(row);
	}

	private void printRow(int row) {
		for (int i = 0; i < cols; i++) {
			lad[i][row].print();
		}
	}

	public static void main(String[] args) {
		Ladder lad = new Ladder(6, 15);
		lad.printLadder();
		System.out.println(lad.start(2));
	}
}