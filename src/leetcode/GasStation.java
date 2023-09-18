package leetcode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int finalCost = gas[0];
        for(int i=0;i<n;i++){
            int j=i+1;
            finalCost = gas[i];
            int k=i;
            while(true){
                int a = finalCost - cost[k];
                if(a<=0)
                    break;
                k++;
                if(k==n-1){
                    k=0;
                }
                if(k==i){
                   break;
                }
                finalCost = a+ gas[k];
            }
        }
        return finalCost;
    }
}
