package mix_questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OneLampLightenedPoint {
   static int oneLampLightenedPoints(int[][] lamps) {
       Map<Integer, Integer> res  = new HashMap<>();
       for(int i=0;i<lamps.length;i++){
           int point = lamps[i][0];
           int radius = lamps[i][1];

           int xLamp1 = point - radius;
           int yLamp1 = point + radius ;
           if(xLamp1<=0){
               for(int j=xLamp1;j<=point;j++){
                   if(res.containsKey(j))
                       res.put(j, res.get(j)+1);
                   else
                       res.put(j, 1);
               }
           }else if (xLamp1>0){
               for(int j=xLamp1;j>=point;j--){
                   if(res.containsKey(j))
                       res.put(j, res.get(j)+1);
                   else
                       res.put(j, 1);
               }
           }

           if(yLamp1<=0){
               for(int j=point-1;j>=yLamp1;j--){
                   if(res.containsKey(j))
                       res.put(j, res.get(j)+1);
                   else
                       res.put(j, 1);
               }
           }else if (yLamp1>0){
               for(int j=point+1;j<=yLamp1;j++){
                   if(res.containsKey(j))
                       res.put(j, res.get(j)+1);
                   else
                       res.put(j, 1);
               }
           }

       }

       int count =0;
       for(Map.Entry<Integer, Integer> map :  res.entrySet()){
           if(map.getValue()==1)
               count++;
       }

       return count;

    }

    public static void main(String[] a){
        int[][] lamps = new int[3][2];
        lamps[0][0]=-2;
        lamps[0][1]=3;
        lamps[1][0]=2;
        lamps[1][1]=3;
        lamps[2][0]=2;
        lamps[2][1]=1;

        System.out.print(oneLampLightenedPoints(lamps));

    }
}
