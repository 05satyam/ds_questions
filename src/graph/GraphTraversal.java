package graph;

import java.util.Iterator;

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
		gTvs.dfs(g, 2);
	}

}
