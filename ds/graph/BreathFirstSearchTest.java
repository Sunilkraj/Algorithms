package learn.ds.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

class Tree<T> {
	private T value;
	private List<Tree<T>> children;
	
	public Tree(T value){
		this.value = value;
		this.children = new LinkedList<Tree<T>>();
	}
	
	public Tree<T> addChild(T child){
		Tree<T> childNode = new Tree<T>(child);
		this.children.add(childNode);
		
		return childNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<Tree<T>> getChildren() {
		return children;
	}

	public void setChildren(List<Tree<T>> children) {
		this.children = children;
	}
}

class BreathFirstSearch<T>{
	public Optional<Tree<T>> search(Tree<T> startNode, Integer searchValue) {
        // STEP 1 : create queue to maintain the next node to be explored.
        Queue<Tree<T>> queue = new ArrayDeque<Tree<T>>();
        // STEP 2: add starting node to list to start the search.
        queue.add(startNode);
        // STEP 3: Iterate until queue is empty
        int counter =0;
        while (!queue.isEmpty()) {
            System.out.println("Iteration "+(++counter));
            // STEP 3.a: get the node from the Queue
            Tree<T> currentNode = queue.remove();
            System.out.println("Get "+ currentNode);
            if (currentNode.getValue().equals(searchValue)) {
                // STEP 3.b: if current node matched with search value, return it.
                return Optional.of(currentNode);
            } else {
                // STEP 3.c: add current node's children to queue, search continues...
                queue.addAll(currentNode.getChildren());
            }
        }
        // STEP 4: Queue is empty that means searchValue doesn't exist in the tree.
        return Optional.empty();
    }
}
public class BreathFirstSearchTest {

	public static void main(String[] args) {
BreathFirstSearch<Integer> searchHelper = new BreathFirstSearch<Integer>();
        
        Tree<Integer> rootNode = createTree();
        
        Integer searchValue = 7;
        Optional<Tree<Integer>> result = searchHelper.search(rootNode, searchValue);
        if (result.isPresent()) {
            System.out.println("Search completed successfully [" + result.get().getValue() + "]");
        } else {
            System.out.println("Node [" + searchValue + "] is not found");
        }
    }
    private static Tree<Integer> createTree() {
        // Create Tree
        Tree<Integer> rootNode = new Tree<Integer>(1);
        
        Tree<Integer> child1 = rootNode.addChild(2);
        child1.addChild(4);
        child1.addChild(5);
        
        Tree<Integer> child2 = rootNode.addChild(3);
        child2.addChild(6);
        child2.addChild(7);
        return rootNode;
    }
}
