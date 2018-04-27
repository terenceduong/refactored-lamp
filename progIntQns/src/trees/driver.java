package trees;

public class driver {
	public static void main(String[] args) {
		BST tree = new BST();
		Node node1 = new Node(20);
		Node node2 = new Node(10);
		Node node3 = new Node(30);
		Node node4 = new Node(5);
		Node node5 = new Node(23);
		Node node6 = new Node(50);
		Node node7 = new Node(40);
		
		tree.insert(node1);
		tree.insert(node2);
		tree.insert(node3);
		tree.insert(node4);
		tree.insert(node5);
		tree.insert(node6);
		tree.insert(node7);
//		node5.value = 1000;
		tree.printTree();
		
//		tree.printTreeDFS(node1);
		
		System.out.println(tree.validateTree(node1));
//		System.out.println(tree.findSecondLargest(node1).value);
	}
}

