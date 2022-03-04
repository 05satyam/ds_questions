package leetcode;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
        if(nums.length<=2)
            return res;

                    Arrays.sort(nums);
                    if(nums[0]>0)
                        return res;
            Map<Integer, Set<Integer>> m = new HashMap<>();

            for(int i=0;i< nums.length;i++){
                if(m.containsKey(nums[i])){
                    Set<Integer> s = m.get(nums[i]);
                    s.add(i);
                    m.put(nums[i], s);

                }else{
                    Set<Integer> s = new HashSet<>();
                    s.add(i);
                    m.put(nums[i], s);
                }
            }

           /* for(Map.Entry<Integer, Set<Integer>> mm: m.entrySet()){
                System.out.print("key "+ mm.getKey() +   "   ");
                Set<Integer> ss = mm.getValue();
                for(Integer ii : ss)
                    System.out.print(ii + "  ");

                System.out.println();
            }*/

            for(int i=0;i<nums.length;i++){
                for(int j=i+1;j<nums.length;j++){
                    int sum  = nums[i] +nums[j];
                    if(nums[nums.length-1]<((-1)*sum))
                        continue;
                    //System.out.println("nums i, j "+   nums[i] + "   "  + nums[j]  + "    sum "+ sum + "   i "+ i + "  j  "+ j);
                    if(m.containsKey((-1)*(sum))){
                       Set<Integer> set  = m.get((-1)*sum);
                       if((set.contains(i) || set.contains(j)))
                           if(set.size()<=2)
                           continue;;


                           List<Integer> newArr = new ArrayList<>();

                          // Collections.sort(newArr);
                          if(((-1)*sum)<nums[i]){
                              newArr.add((-1)*sum);
                              newArr.add(nums[i]);
                              newArr.add(nums[j]);

                          }else if(((-1)*sum)<nums[j]){

                              newArr.add(nums[i]);newArr.add((-1)*sum);
                              newArr.add(nums[j]);
                          }else{
                              newArr.add(nums[i]);
                              newArr.add(nums[j]);
                              newArr.add((-1)*sum);
                          }
                           if(!res.contains(newArr))
                           res.add(newArr);


                    }
                }
            }
            return res;
    }

    //optimized
    public List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] s){
        int arr[] = {-1,0,1,2,-1,-4 };
        System.out.println( "main " + threeSum(arr));

    }
}
