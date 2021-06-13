package learn.ds.bst;

import java.util.Stack;

public class TreeTraversals {

	public static void main(String[] args) {
		Node root = new Node(20);

		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		
		root.right.left = new Node(25);
		root.right.right = new Node(35);
//		System.out.println("Inorder traversal Recursion");
//		InorderRecursion inorder = new InorderRecursion();
//		inorder.inorderTraversal(root);
//		
//		System.out.println("Preorder traversal Iterative");
//		PreorderIterator preorder = new PreorderIterator();
//		preorder.preorder(root);
//		
//		System.out.println("Preorder traversal");
//		PreorderRecursion pre = new PreorderRecursion();
//		pre.preorderTraversal(root);
		
		System.out.println("Postorder traversal");
		PostorderRecursion po = new PostorderRecursion();
		po.postorderTraversal(root);
		
		System.out.println("Postorder traversal iterative");
		PostorderIterator post = new PostorderIterator();
		post.postorder1(root);
		System.out.println("Using two stack");
		post.postorder2(root);
	}

}
class Node<T>{
	T data;
	Node<T> left;
	Node<T> right;
	

	Node(T data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	
}

class InorderRecursion{
	
	public void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		
		if (root != null) {
			inorderTraversal(root.left);
			System.out.println(root.data);
			inorderTraversal(root.right);
		}
	}
}

class PreorderRecursion{
	
	public void preorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		
		if (root != null) {
			System.out.println(root.data);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}
}

class PostorderRecursion{
	
	public void postorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.println(root.data);
		}
	}
}


//iterative
//			    20
//		10		        30
//	5		15 		25		35
	

class PreorderIterator{
	public void preorder(Node root){
		Stack<Node> s = new Stack<Node>();
		
		while (!s.isEmpty() || root != null) {
			while(root != null) {
				System.out.println(root.data);
				s.push(root);
				root=root.left;
			}
			
			if (s.isEmpty()) {
				//break;
			}
			
			root = s.pop();
			root = root.right;
		}
	}
}


class InorderIterator{
	public void inorder(Node root){
		Stack<Node> s = new Stack<Node>();
		
		while (!s.isEmpty() || root != null) {
			while(root != null) {
				s.push(root);
				root=root.left;
			}
			
			if (s.isEmpty()) {
				//break;
			}
			
			root = s.pop();
			System.out.println(root.data);
			root = root.right;
		}
	}
}


class PostorderIterator{
	public void postorder1(Node root){
		Stack<Node> s = new Stack<Node>();
		
		while (!s.isEmpty() || root != null) {
			while(root != null) {
				if (root.right != null) {
					s.push(root.right);
				}
				s.push(root);
				root=root.left;
			}

			root = s.pop();
			
			if (root.right  == s.peek()) {
				s.pop();
				s.push(root);
				root = root.right;
			}else {
				System.out.println(root.data);
				root=null;
			}
		}
	}
	
	
	public void postorder2(Node root){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		s1.push(root);
		
		Node node = null;
		
		while (!s1.isEmpty()) {
			node = s1.pop();
			
			s2.push(node);
			
			if (node.left != null) {
				s1.push(node.left);
			}
			
			if (node.right != null) {
				s1.push(node.right);
			}
		}
		
		while (!s2.isEmpty()) {
			System.out.println(s2.pop().data);
		}
	}
	
}









