/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
*/

package graph;

public class ConnectedCitiesCount {
    public static int connectedCityCount(int[][] g) {
        int n = g.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(g, i, n, visited);
                count++;
            }
        }
        return count;
    }

    public static void dfs(int[][] g, int idx, int gLen, boolean[] visited) {
        for (int j = 0; j < gLen; j++) {
            if (!visited[j] && g[idx][j] == 1) {
                visited[j] = true;
                dfs(g, idx, gLen, visited);
            }
        }
    }

    public static void main(String[] arg){
        int[][] g = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(connectedCityCount(g));
    }
}
