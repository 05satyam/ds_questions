/***
 * Graph using adjacency matrix
 * 
 */
package graph;

public class GraphAdjMatrix {
	private boolean adjMatrix[][];
	private int v;

	public GraphAdjMatrix(int v) {
		this.v = v;
		adjMatrix = new boolean[v][v];
	}

	public void addEdge(int i, int j) {
		adjMatrix[i][j] = true;
		adjMatrix[j][i] = true;
	}

	public void removeEdge(int i, int j) {
		adjMatrix[i][j] = false;
		adjMatrix[j][i] = false;
	}

	public boolean isEdge(int i, int j) {
		return adjMatrix[i][j];
	}

	public String printG() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < v; i++) {
			s.append(i + ": ");
			for (boolean j : adjMatrix[i]) {
				s.append((j ? 1 : 0) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}

	public static void main(String args[]) {
		GraphAdjMatrix g = new GraphAdjMatrix(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);

		System.out.print(g.printG());
       /* Outputs
          0: 0 1 1 0 
          1: 1 0 1 0 
          2: 1 1 0 1 
          3: 0 0 1 0 
         */
   }
}
