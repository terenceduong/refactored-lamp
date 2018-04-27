package trees;

import java.util.ArrayList;

//Implement a BST with insert and delete functions

public class BST {
	Node root;
	BST() {
		root = null;
	}
	
	BST(Node root) {
		this.root = root;
	}
	
	void insert(Node aNode) {
		if (root == null)
			root = aNode;
		else {
			insertRecurse(root, aNode);
		}
	}
	void insert(int value) {
		if (root == null)
			root = new Node(value);
		else {
			Node aNode = new Node(value);
			insertRecurse(root, aNode);
		}
	}
	
	void insertRecurse(Node aNode, Node newNode) {
		if (newNode.value > aNode.value) {
			if (aNode.rightChild == null) {
				aNode.rightChild = newNode;
				newNode.parent = aNode;
			}
			else
				insertRecurse(aNode.rightChild, newNode);
		} else if (newNode.value < aNode.value){
			if (aNode.leftChild == null) {
				aNode.leftChild = newNode;
				newNode.parent = aNode;
			}
			else
				insertRecurse(aNode.leftChild, newNode);
		}
	}
	
	boolean delete(Node aNode) {
		if (root == null) {
			return false;
		} else if (aNode.leftChild == null && aNode.rightChild == null){
			System.out.println("no kids");
			if (aNode.parent.rightChild == aNode)
				aNode.parent.rightChild = null;
			else
				aNode.parent.leftChild = null;
			return true;
		} else if (aNode.leftChild != null && aNode.rightChild != null) {
			aNode.value = findMin(aNode.rightChild).value;
			return delete(findMin(aNode.rightChild));
		} else {
			Node newNode;
			if (aNode.leftChild != null)
				newNode = aNode.leftChild;
			else 
				newNode = aNode.rightChild;
			
			newNode.parent = aNode.parent;
			if (aNode == aNode.parent.leftChild) {
				aNode.parent.leftChild = newNode;
			} else
				aNode.parent.rightChild = newNode;
			return true;
		}
	}
	
//	
//	boolean delete(int value) {
//		if (root == null)
//			return false;
//		else {
//			return deleteRecurse(root, value);
//		}
//	}
//	
//	boolean deleteRecurse(Node aNode, int value) {
//		// value is found
//		if (value == aNode.value) {
//			// node containing value has no children
//			// remove it immediately
//			if (aNode.leftChild == null && aNode.rightChild == null) {
//				// node has no parent
//				// this is the root
//				if (aNode.parent == null)
//					root = null;
//				
//				else { // node has parent
//					// check if this node is left or right of the parent
//					if (aNode == aNode.parent.leftChild)
//						aNode.parent.leftChild = null;
//					else
//						aNode.parent.rightChild = null;
//				}
//			// has two children
//			} else if (aNode.leftChild != null && aNode.rightChild != null) {
//				// find min node in right subtree of aNode
//				// switch and delete aNode
//				Node newNode = findMin(aNode.rightChild);
//				int tempValue = aNode.value;
//				aNode.value = newNode.value;
//				newNode.value = tempValue;
//				deleteRecurse(newNode, value);
//				
//			
//			} else { // has one child
//				Node newNode;
//				if (aNode.leftChild != null)
//					newNode = aNode.leftChild;
//				else
//					newNode = aNode.rightChild;
//				
//				if (aNode == aNode.parent.leftChild) {
//					aNode.parent.leftChild = newNode;
//				} else {
//					aNode.parent.rightChild = newNode;
//				}
//				newNode.parent = aNode.parent;
//			}
//		}
//		return false;
//	}
//	
	Node findMin(Node root) {
		if (root.leftChild == null)
			return root;
		else
			return findMin(root.leftChild);
	}
	
//	Node findSecondLargest(Node root) {
//		if (root.rightChild == null)
//			if (root.leftChild != null)
//				return findSecondLargest(root.leftChild);
//			else 
//				return root.parent;
//		else
//			return findSecondLargest(root.rightChild);
//	}
	
	boolean validateTree(Node root) {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		nodeList.add(root);
		Node thisNode;
		while (nodeList.size() != 0) {
			thisNode = nodeList.remove(0);
			if (thisNode.leftChild != null)
				if (thisNode.leftChild.value > thisNode.value)
					return false;
				else
					nodeList.add(thisNode.leftChild);
			if (thisNode.rightChild != null)
				if (thisNode.rightChild.value < thisNode.value)
					return false;
				else
					nodeList.add(thisNode.rightChild);
				
		}
		return true;
	}

	void printTreeDFS(Node root) {
		System.out.println(root.value);
		if (root.leftChild != null)
			printTreeDFS(root.leftChild);
		if (root.rightChild != null)
			printTreeDFS(root.rightChild);
	}
	
	void printTree() {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		nodeList.add(root);
		printTreeRecurse(nodeList);
	}
	void printTree(Node root) {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		nodeList.add(root);
		printTreeRecurse(nodeList);
	}
	
	void printTreeRecurse(ArrayList<Node> nodeList) {
		int numNodes = nodeList.size();
		Node thisNode;
		for (int i = 0; i < numNodes; i++) {
			thisNode = nodeList.remove(0);
			if (thisNode != null) {
				thisNode.printNode();
				if (thisNode.leftChild != null)
					nodeList.add(thisNode.leftChild);
				else
					nodeList.add(null);
				if (thisNode.rightChild != null)
					nodeList.add(thisNode.rightChild);
				else
					nodeList.add(null);
			} else {
				System.out.print("\t ");
			}
		}
		System.out.println();
		if (nodeList.size() != 0)
			printTreeRecurse(nodeList);
	}
}