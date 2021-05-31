/*
*
* You are given two integers memory1 and memory2 representing the available memory in bits on two memory sticks. There is currently a faulty program running that consumes an increasing amount of memory every second.

At the ith second (starting from 1), i bits of memory are allocated to the stick with more available memory (or from the first memory stick if both have the same available memory). If neither stick has at least i bits of available memory, the program crashes.

Return an array containing [crashTime, memory1crash, memory2crash], where crashTime is the time (in seconds) when the program crashed and memory1crash and memory2crash are the available bits of memory in the first and second sticks respectively.



Example 1:

Input: memory1 = 2, memory2 = 2
Output: [3,1,0]
Explanation: The memory is allocated as follows:
- At the 1st second, 1 bit of memory is allocated to stick 1. The first stick now has 1 bit of available memory.
- At the 2nd second, 2 bits of memory are allocated to stick 2. The second stick now has 0 bits of available memory.
- At the 3rd second, the program crashes. The sticks have 1 and 0 bits available respectively.
* */

package leetcode;

public class IncrementalMemoryLeak {
    public static int[] memLeak(int memory1, int memory2) {
        int res[] = new int[3];
        int i=1;
        while(true){
            if(memory1>memory2 && memory1>=i){
                memory1-=i;

            }else if(memory2>memory1 && memory2>=i){
                memory2-=i;
            }else if(memory1==memory2 && memory1>=i){
                memory1-=i;
            }else if(memory1<i && memory2<i){

                break;
            }

            i++;

        }

        res[0]=i;
        res[1]=memory1;
        res[2]=memory2;
        return res;
    }


    public static void main(String[] a){
        int res[] = memLeak(8,11);
        for(int i=0;i<res.length;i++)
        System.out.println(res[i]);
    }
}
