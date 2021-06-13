package learn.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

class Graph{
	private int V; // number of nodes in a graph.
	private LinkedList<Integer> adj[];
	private Queue<Integer> queue;
	
	public Graph(int v){
		this.V = v;
		adj = new LinkedList[v];
		
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		queue = new LinkedList<Integer>();
	}
	
	public void addEdge (int v, int w) {
		adj[v].add(w);
	} 
	
	public void BFS(int n) {
		boolean visited[] = new boolean[V];
		visited[n] = true;
		queue.add(n);
		int a;
		
		while (!queue.isEmpty()) {
			n = queue.poll();
			System.out.println(n+" ");
			
			for (int i = 0; i < adj[n].size(); i++) {
				a = adj[n].get(i);
				if (!visited[a]) { // if a is not visited
					 visited[a] = true;
					 queue.add(a);
				}
			}
		}
	}
} 


public class BFSTraversal {
	public static void main(String args[])
    {
        Graph graph = new Graph(6); // 6 verteces
 
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
 
        System.out.println("The Breadth First Traversal of the graph is as follows :");
 
        graph.BFS(0);
    }
}
