
/***
 * @author satyam
 *
 * graph class using adjacency list
 */

package graph;

import java.util.LinkedList;

public class GraphAdjList {
	static class Graph{
		int v;
		LinkedList<Integer> adjArray[];
		
		Graph(int v) {
			this.v = v;
			adjArray = new LinkedList[v];
			for (int i = 0; i < v; i++)
				adjArray[i] = new LinkedList<>();
		}
		
	}

	void addEdge(Graph g, int src, int dest) {
		g.adjArray[src].add(dest);
		g.adjArray[dest].add(src);
	}

	void printGraph(Graph g) {
		for (int v = 0; v < g.v; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : g.adjArray[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String args[]) 
    { 
        // create the graph given in above figure 
        int V = 5; 
        GraphAdjList graphAdj = new GraphAdjList();
        Graph graph = new Graph(V);
        graphAdj.addEdge(graph, 0, 1); 
        graphAdj.addEdge(graph, 0, 4); 
        graphAdj.addEdge(graph, 1, 2); 
        graphAdj.addEdge(graph, 1, 3); 
        graphAdj.addEdge(graph, 1, 4); 
        graphAdj.addEdge(graph, 2, 3); 
        graphAdj.addEdge(graph, 3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
        graphAdj.printGraph(graph); 
    } 
}
