package leetcode;

public class PaintHouse {
    public static int minCost(int[][] costs) {
        int a=costs[0][0];
        int b=costs[0][1];
        int c=costs[0][2];

       for(int i=1;i<costs.length;i++){
           costs[i][0]+= Math.min(costs[i-1][1], costs[i-1][2]);
           costs[i][1]+= Math.min(costs[i-1][0], costs[i-1][2]);
           costs[i][2]+= Math.min(costs[i-1][1], costs[i-1][0]);


       }
int n =costs.length;
       return Math.min(Math.min(costs[n-1][0], costs[n-1][1]),costs[n-1][2]);
    }

    public static void main(String[] a){
        int[][] cost = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(cost));
    }







}
