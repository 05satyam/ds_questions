/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.
 *
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 *
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 *
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 *
 * It's guaranteed that each city can reach city 0 after reorder.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * Output: 3
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 * Example 2:
 *
 *
 * Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * Output: 2
 * Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
 */
package leetcode;

import javafx.application.Application;
import javafx.stage.Stage;

public class ReorderRouteToMakeAllPathLeadToCityZero {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> lst = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            lst.add(new ArrayList<>());
        for(int[] c : connections){
            lst.get(c[0]).add(c[1]);
            lst.get(c[1]).add(-1 * c[0]);
        }

        return dfs(lst, new boolean[n], 0);
    }

    public int dfs( List<List<Integer>> lst, boolean[] vis, int node){
        int c = 0;
        vis[node]=true;
        for(Integer ii : lst.get(node)){
            if(!vis[Math.abs(ii)]){
                c += dfs(lst, vis, Math.abs(ii)) + (ii > 0 ? 1 : 0);
            }
        }

        return c;
    }
}
