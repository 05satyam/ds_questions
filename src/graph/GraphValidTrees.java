package graph;

import java.util.*;

public class GraphValidTrees {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> edgesConnection  =  new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];

            if(edgesConnection.containsKey(b))
                return false;
            else{
                if(edgesConnection.containsKey(a)){
                    List<Integer> list = edgesConnection.get(a);
                    list.add(b);
                    edgesConnection.put(a, list);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(b);
                    edgesConnection.put(a, list);
                }
            }

        }
        return true;

    }
}
