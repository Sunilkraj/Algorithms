package learn.ds.bst;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(20);

		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		
		root.right.left = new Node(25);
		root.right.right = new Node(35);
		
		LevelOrder lev = new LevelOrder();
		lev.LevelOrderTraversal(root);
	}
}

class LevelOrder {
	public void LevelOrderTraversal(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp = null;
		
		while (!q.isEmpty()) {
			temp = q.poll();
			System.out.println(temp.data);
			
			if (temp.left != null) {
				q.add(temp.left);
			}
			
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
	}

}