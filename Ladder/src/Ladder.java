import java.util.ArrayList;
import java.util.Random;

public class Ladder {
	private Node[][] lad;
	private int cols, rows;
	// 사다리 가로줄의 최대치를 고정해 두는 상수
	private final int wRows = 12;
	// 연속으로 가로줄이 나오지 않기 위해서 바로 전 가로줄을 저장해두는 리스트
	private ArrayList<Integer> prvSelectedRows;

	public Ladder(int cols, int rows) throws IllegalArgumentException {
		if (cols < 1 || rows < 0) {
			throw new IllegalArgumentException("열 값은 1이상 연결 값은 0이상 이어야 합니다.");
		}
		this.cols = cols;
		this.rows = rows;
		lad = new Node[cols][12];
		prvSelectedRows = new ArrayList<Integer>();
		// 노드의 다운 포인터 지정을 위해서 아래서부터 노드 초기화
		for (int i = cols - 1; i >= 0; i--) {
			setUpCol(i);
		}
		if (cols > 1) {
			makeLadder();
		}
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

	public int start(int num) throws IllegalArgumentException {
		if (num > cols) {
			throw new IllegalArgumentException(
					"게임을 시작하기 위해 입력한 값은 컬럼 값 이하여야 합니다.");
		}
		int val = lad[num - 1][0].go().getPos_x() + 1;
		System.out.println();
		return val;
	}

	private void setUpCol(int col) {
		for (int i = wRows - 1; i >= 0; i--) {
			setUpNode(col, i);
		}
	}

	private void setUpNode(int col, int row) {
		if (row < wRows - 1) {
			lad[col][row] = new Node(col, row, lad[col][row + 1]);
			return;
		}
		lad[col][row] = new Node(col, row);
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
	private void linkNodes(int col, int row) {
		try {
			lad[col][row].makeLink(0, lad[col + 1][row]);
			lad[col + 1][row].makeLink(1, lad[col][row]);
		} catch (Node.OutOfRangeFlagException e) {
			System.out.println(e.getMessage());
		}
	}

	// link 2 columns
	private void linkCols(int numOfCol, int numOfRows) {
		ArrayList<Integer> rowList = new ArrayList<Integer>();
		for (int i = 1; i < wRows - 1; i++) {
			buildRowList(rowList, i);
		}
		prvSelectedRows = new ArrayList<Integer>();
		Random rdm = new Random();
		 try {
		// link nodes randomly without duplication
		for (int i = 0; i < numOfRows; i++) {
			int row = rdm.nextInt(rowList.size());
			prvSelectedRows.add(rowList.get(row));
			linkNodes(numOfCol, rowList.get(row));
			rowList.remove(row);
		}
		 } catch (IllegalArgumentException e) {
			 e = new IllegalArgumentException("연결 값이 너무 큽니다. 연결 값을 줄여 주세요.");
			 throw e;
		 }
	}

	// 연결할 row list를 이전 col에서 연결한 row를 제외하고
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
		try {
			Ladder lad = new Ladder(6, 20);
			lad.printLadder();
			System.out.format("선택된 값은 %d 입니다. \n", lad.start(2));
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}