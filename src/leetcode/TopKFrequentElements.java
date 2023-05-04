/**
 *
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 */

package leetcode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class ValueComparator implements Comparator<Integer> {
    Map<Integer, Integer> map;

    public ValueComparator(Map<Integer, Integer> map) {
        this.map = map;
    }

    public int compare(Integer o1, Integer o2) {
        int cmp = Integer.compare(map.get(o2), map.get(o1));
        if (cmp == 0) {
            // If the values are equal, compare the keys in ascending order
            cmp = o1.compareTo(o2);
        }
        return cmp;

        //return Integer.compare(map.get(o2), map.get(o1));
    }
}


class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // Create a TreeMap with a custom Comparator
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        Map<Integer, Integer> sortedMap = new TreeMap<>(new ValueComparator(map));
        sortedMap.putAll(map);


        int[] arr = new int[k];
        int i=0;

        for(Map.Entry<Integer,Integer> entry : sortedMap.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
            if(i>=k)
                break;
            else
                arr[i] = entry.getKey();
            i++;
        }


        return  arr;
    }
}
