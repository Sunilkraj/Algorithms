package learn.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

class BFSGraph{
	private int V; // number of nodes in a graph.
	private LinkedList<Integer> adj[];
	private Queue<Integer> queue;
	
	public BFSGraph(int v){
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
		boolean nodes[] = new boolean[V];
		nodes[n] = true;
		queue.add(n);
		int a;
		
		while (!queue.isEmpty()) {
			n = queue.poll();
			System.out.println(n+" ");
			
			for (int i = 0; i < adj[n].size(); i++) {
				a = adj[n].get(i);
				if (!nodes[a]) { // if a is not visited
					 nodes[a] = true;
					 queue.add(a);
				}
			}
		}
	}
} 

public class BFSRecursion {
	public static void main(String[] args) {
		
	}
}
