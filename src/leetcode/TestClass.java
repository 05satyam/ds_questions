//directed graph, src to  destination path found or not
package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class TestClass{
    private int V;
    private LinkedList<Integer> adj[];
    TestClass(int v){
        V=v;
        adj= new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]= new LinkedList();
        }
    }
    void addEdge(int v, int w){
    	System.out.println("v: " + v +", w: "+ w);
        adj[v].add(w);
    }
    boolean isReachable(int s, int d){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> q = new LinkedList<Integer>();
        visited[s]=true;
        Iterator<Integer>i;
        q.add(s);
        while(q.size()!=0){
            s=q.poll();
            int n;
            i=adj[s].listIterator();
            while(i.hasNext()){
                n=i.next();
                if(n==d)return true;
                if(!visited[n]){
                    visited[n]=true;
                    q.add(n);
                }
            }
        }
    return false;
    }

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //br.readLine();
        int memN= Integer.parseInt(br.readLine());
     System.out.println(memN);
     
      int edg= Integer.parseInt( br.readLine());
      System.out.println("edg "+ edg);
      TestClass g = new TestClass(memN+1);
      for(int i=0;i<edg;i++){
          int a= Integer.parseInt( br.readLine());
          int b= Integer.parseInt( br.readLine());
          g.addEdge(a,b);
      }
      int a= Integer.parseInt( br.readLine());
      int b= Integer.parseInt( br.readLine());
      System.out.println("src" + a);
      System.out.println("dest " + b);
      System.out.println(g.isReachable(a,b));
    }
}
