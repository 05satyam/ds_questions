/**
 * There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 *
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.
 *
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 * Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
 * Example 2:
 *
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

public class FindCenterOfGraph {
    public static int findCenter(int[][] graph) {
        Map<Integer, Integer> nodeCount = new HashMap<>();
        for(int i=0;i<graph.length;i++){
            int a=graph[i][0];
            int b=graph[i][1];

            if(nodeCount.containsKey(a))
                nodeCount.put(a, nodeCount.get(a)+1);
            else
                nodeCount.put(a, 1);

            if(nodeCount.containsKey(b))
                nodeCount.put(b, nodeCount.get(b)+1);
            else
                nodeCount.put(b, 1);


        }

        for(Map.Entry<Integer, Integer> map: nodeCount.entrySet()){
            if(map.getValue()==graph.length)
                return map.getKey();
        }
        return 0;
    }
    public static void main(String[] a){
        int g[][] = {{1,2},{2,3},{4,2}};
        System.out.println(findCenter(g));
    }
}
