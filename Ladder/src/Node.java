public class Node {
	private int pos_x;
	private int pos_y;
	private Node l_node;
	private Node r_node;
	private Node d_node;
	private static Node prevNode;

	public Node go() {
		System.out.format("%d, %d /", this.pos_x, this.pos_y);
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

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}

	public Node getL_node() {
		try {
			return l_node;
		} catch (NullPointerException nu) {
			return null;
		}
	}

	public void setL_node(Node l_node) {
		this.l_node = l_node;
	}

	public Node getR_node() {
		try {
			return r_node;
		} catch (NullPointerException nu) {
			return null;
		}
	}

	public void setR_node(Node r_node) {
		this.r_node = r_node;
	}

	public Node getD_node() {
		try {
			return d_node;
		} catch (NullPointerException nu) {
			return null;
		}
	}

	public void setD_node(Node d_node) {
		this.d_node = d_node;
	}
}
