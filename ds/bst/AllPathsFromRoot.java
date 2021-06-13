package learn.ds.bst;

public class AllPathsFromRoot {

	public static void main(String[] args) {
		Node root = new Node(20);

		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);

		root.right.left = new Node(25);
		root.right.right = new Node(35);

		RootToLeafPaths p = new RootToLeafPaths();
		int[] path = new int[100];
		p.printAllPaths(root, path, 0);
		
		RootToLeafPathsSum rs = new RootToLeafPathsSum();
		rs.printAllPaths(root, path, 0, 35);
	}
}

class RootToLeafPaths {

	public void printAllPaths(Node root, int[] path, int pathLength) {
		if (root == null) {
			return;
		}

		path[pathLength] = (int) root.data;
		pathLength++;

		if (root.left == null && root.right == null) {
			printPaths(path, pathLength);
		} else {
			printAllPaths(root.left, path, pathLength);
			printAllPaths(root.right, path, pathLength);
		}
	}

	private void printPaths(int[] path, int pathLength) {
		for (int i = 0; i < pathLength; i++) {
			System.out.println(path[i]);
		}
		System.out.println("-----------------------------");
	}
}

class RootToLeafPathsSum {

	public void printAllPaths(Node root, int[] path, int pathLength, int sum) {
		int pathExists = 0;
		if (root == null) {
			return;
		}

		path[pathLength] = (int) root.data;
		pathLength++;

		if (sum == sumThePath(path, pathLength)) {
			System.out.println("Path Exists!!");
			return;
		}
		if (root.left == null && root.right == null) {
			if (sum == sumThePath(path, pathLength)) {
				System.out.println("Path Exists!!");
				
			}
		} else {
			printAllPaths(root.left, path, pathLength, sum);
			printAllPaths(root.right, path, pathLength, sum);
		}
	}

	private int sumThePath(int[] path, int pathLength) {
		int sum = 0;
		for (int i = 0; i < pathLength; i++) {
			sum = sum + path[i];
		}
		return sum;
	}

	private void printPaths(int[] path, int pathLength) {
		for (int i = 0; i < pathLength; i++) {
			System.out.println(path[i]);
		}
		System.out.println("-----------------------------");
	}
}

class ZigZagPath{
	
	
}