/*
* Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
*
* Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
* */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if(graph.length==0)
            return res;

        path.add(0);
            dfs(path, 0, res, graph);
        return res;
    }

    private static void dfs(List<Integer> path, int node, List<List<Integer>> res, int[][] g){
        if(node==g.length-1){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int n: g[node]){
            path.add(n);
            dfs(path, n, res, g);
            path.remove(path.size()-1);
        }
        return;
    }

    public static void main(String[] a){
        int g[][] = {{1,2},{3},{3},{}};
        List<List<Integer>> res = allPathsSourceTarget(g);
        for(List ll : res)
            System.out.println(ll);
    }
}
