package learn.ds.bst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeHeight {

	public static void main(String[] args) {
		Node root = new Node(20);

		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		
		root.right.left = new Node(25);
		root.right.right = new Node(35);
		
		Height ht = new Height();
		int height = ht.findHeight(root);
		System.out.println("height: "+height);
	}
}

class Height{
	
	public int findHeight(Node root) {
		if (root == null) {
			return 0;
		}
		
		int leftTreeSize = findHeight(root.left);
		int rightTreeSize = findHeight(root.right);
		
		return (leftTreeSize > rightTreeSize ? leftTreeSize+1 : rightTreeSize+1);
	}
	
	public int findHeightIterative(Node root) {
		if (root == null) {
			return 0;
		}
		
		Node temp = null;
		int level = 1;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		
		while (!q.isEmpty()) {
			temp = q.poll();
			
			if(root == null) {
				if (!q.isEmpty()) {
					q.add(null);
				}
				level++;
			}else {
				if (temp.left != null) {
					q.add(temp.left);
				}
				
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}
	
		return level;
	}
}