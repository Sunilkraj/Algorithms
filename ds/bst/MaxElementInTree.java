package learn.ds.bst;

public class MaxElementInTree {

	public static void main(String[] args) {
		Node root = new Node(20);

		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);

		root.right.left = new Node(25);
		root.right.right = new Node(35);

		MaxElementSearch m = new MaxElementSearch();
		int max = m.findMx(root);
		System.out.println("Max element: " + max);

		int isFound = m.findElement(root, 30);
		System.out.println("isFound: " + isFound);
	}

}

class MaxElementSearch {
	int max = 0;

	public int findMax(Node root) {

		if (root != null) {
			int root_val = (int) root.data;

			int left = findMax(root.left);
			int right = findMax(root.right);

			max = left > right ? left : right;

			if (root_val > max) {
				max = root_val;
			}
		} else {
			return 0;
		}

		return max;
	}

	public int findMx(Node root) {
		if (root == null) {
			return 0;
		}

		int res = (int) root.data;
		int max;
		int left = findMx(root.left);
		int right = findMx(root.right);
//	    if(left > res){
//	        res = left;
//	    }
//	    if(right > res) {
//	        res = right;
//	    }
		res = (left > res ? left : (right > res ? right : res));
		// max = left > right ? left : right;

		// max = res > max ? res : max;

		return res;
	}

	public int findElement(Node root, int data) {
		if (root == null) {
			return 0;
		}
		if ((int)root.data == data) {
			return 1;
		}
		int temp = findElement(root.left, data);
		if (temp > 0) {
			return temp;
		}else {
			return findElement(root.right, data);
		}
	}
	
}