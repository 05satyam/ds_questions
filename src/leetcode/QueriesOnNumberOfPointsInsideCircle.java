package leetcode;

public class QueriesOnNumberOfPointsInsideCircle {
    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int x=queries[i][0];
            int y=queries[i][1];
            int r=queries[i][2];
            int count=0;
            for(int j=0;j<points.length;j++){
                int x1=points[j][0];
                int y1=points[j][1];

                if(((x1-x)*(x1-x)+((y1-y)*(y1-y))) <= (r*r))
                    count++;
            }

            res[i]=count;
        }
        return res;
    }
    public static void main(String[] a){
        int[][] points=  {{1,3},{3,3},{5,3},{2,2}};
        int[][] queries= {{2,3,1}, {4,3,1},{1,1,2}};
        int[] res = countPoints(points, queries);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
