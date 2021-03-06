public class Node {
	private int pos_x;
	private int pos_y;
	private Node l_node;
	private Node r_node;
	private Node d_node;
	private static Node prevNode;
	private static OutOfRangeFlagException outOfRangeEx;

	public Node(int x, int y) {
		pos_x = x;
		pos_y = y;
	}

	public Node(int x, int y, Node d) {
		pos_x = x;
		pos_y = y;
		d_node = d;
	}

	public Node go() {
		System.out.format("%d, %d / ", this.pos_x, this.pos_y);
		if (l_node != null && l_node != prevNode) {
			prevNode = this;
			return l_node.go();
		}
		if (r_node != null && r_node != prevNode) {
			prevNode = this;
			return r_node.go();
		}
		if (d_node != null) {
			return d_node.go();
		}
		return this;
	}

	public void makeLink(int flag, Node n) throws OutOfRangeFlagException {
		if (flag == 0) {
			r_node = n;
			return;
		}
		if (flag == 1) {
			l_node = n;
			return;
		}
		throw outOfRangeEx;
	}

	public void makeLink(int flag, Node n, Node d) throws OutOfRangeFlagException {
		if (flag == 0) {
			System.out.println("d linked");
			r_node = n;
			d_node = d;
			return;
		}
		if (flag == 1) {
			l_node = n;
			d_node = d;
			return;
		}
		throw outOfRangeEx;
	}

	public void print() {
		String str = "|  ";
		if (r_node != null) {
			str = "|--";
		}
		System.out.print(str);
	}

	public int getPos_x() {
		return pos_x;
	}

	static class OutOfRangeFlagException extends Exception {
		private String msg = "You've entered a flag out of range!";

		@Override
		public String getMessage() {
			return msg;
		}

	}
}
