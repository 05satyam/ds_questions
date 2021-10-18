/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
A province is a group of directly or indirectly connected cities and no other cities outside of the group.
You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
*/

package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectedCitiesCount {
//['1100', '1110', '0110', '0001']
    public static int connectedCityCount(int[][] g) {
        List<String> list = Arrays.asList("1110", "1010", "1011", "1110");
        int[][] array = new int[list.size()][list.get(0).length()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                array[i][j] = list.get(i).charAt(j)-'0';
            }
        }
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
