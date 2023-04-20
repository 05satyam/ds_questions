/**
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 */
package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class AstroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {

            Stack<Integer> sc = new Stack<>();
            for(Integer i : asteroids){
//
                if(sc.empty()) {
                    sc.push(i);
                    continue;
                }

                if((sc.peek() == i) || (sc.peek()>0 && i>0) || (sc.peek()<0 && i<0)){
                    sc.push(i);
                    continue;
                }

                if(sc.peek()>0 && i<0 && (Math.abs(sc.peek())==Math.abs(i))){
                    sc.pop();
                    continue;
                }
                if(sc.peek()>0 && i<0 && (Math.abs(sc.peek())<Math.abs(i))){

                        sc.pop();
                        while(true){
                            if(sc.size()>0 && sc.peek()>0 && i<0 && (Math.abs(sc.peek())<Math.abs(i))){
                                sc.pop();
                            }else if(sc.size()>0 && sc.peek()>0 && i<0 && (Math.abs(sc.peek())>Math.abs(i))){
                                break;
                            }else if(sc.size()>0 && sc.peek()>0 && i<0 && (Math.abs(sc.peek())==Math.abs(i))){
                                sc.pop();
                                break;
                            }else{
                                sc.push(i);
                                break;
                            }

                            if(sc.size()==0){
                                sc.push(i);
                                break;
                            }


                        }

                }else if(sc.peek()<0 && i>0 ){
                    sc.push(i);
                }

            }

//            System.out.println();
//            System.out.println("stack size "+ sc.size());
        int[] array = new int[sc.size()];
        for (int ii = array.length-1; ii >=0; ii--) {
            int pop=sc.pop();
//            System.out.println("pop "+ pop);
            array[ii] = pop;
        }
            return array;
    }

    public static void main(String[] s){
        int arr[] = {1,1,-2,-2};

        int[] res = asteroidCollision(arr);
        System.out.println("in main res");
        for (int i = 0; i < res.length ;i++) {
            System.out.println(res[i] + "  ");
        }
    }
}
