package trees;

public class Node {
	int value;
	Node parent;
	Node leftChild = null;
	Node rightChild = null;
	
	Node() {
		
	}
	
	Node(int value) {
		this.value = value;
	}
	
	Node (int value, Node parent) {
		this.value = value;
		this.parent = parent;
	}
	
	public void changeValue(int value) {
		this.value = value;
	}
	
	public void printNode() {
		if (parent != null)
			System.out.printf("%d(%d)\t", value, parent.value);
		else 
			System.out.printf("%d(NA)\t", value);
	}
}
