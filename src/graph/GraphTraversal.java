package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphTraversal extends GraphAdjList {

	protected void dfs(Graph g, int src) {
		boolean visited[] = new boolean[g.v];
		dfsUtil(g, src, visited);

	}

	protected void dfsUtil(Graph g, int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> i = g.adjArray[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				dfsUtil(g, n, visited);
		}
	}

	protected void bfs(Graph g,int s) {
		boolean visited[] = new boolean[g.v]; 
		  
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            s = queue.poll(); 
            System.out.print(s+" "); 
            Iterator<Integer> i = g.adjArray[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        }
	}
	public static void main(String[] args) {
		GraphTraversal gTvs = new GraphTraversal();
		GraphAdjList gAdj = new GraphAdjList();
		Graph g = new Graph(4);
		gAdj.addEdge(g, 0, 1);
		gAdj.addEdge(g, 0, 2);
		gAdj.addEdge(g, 1, 2);
		gAdj.addEdge(g, 2, 0);
		gAdj.addEdge(g, 2, 3);
		gAdj.addEdge(g, 3, 3);
		System.out.println("DFS:"); 
		gTvs.dfs(g, 2);
		System.out.println();
		System.out.println("BFS:");
		gTvs.bfs(g, 2);
	}

}
