/**.
 * Given two sparse vectors, compute their dot product.
 *
 * Implement class SparseVector:
 *
 * SparseVector(nums) Initializes the object with the vector nums
 * dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
 * A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.
 *
 * Follow up: What if only one of the vectors is sparse?
 *
 *
 * Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
 * Output: 8
 * Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
 * v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
 *
 *
 *
 */
package leetcode.google;

import java.util.ArrayList;
import java.util.List;

public class SparseVector {
    List<Integer> sparseArr = new ArrayList<>();

    public void setSparseArr(List<Integer> sparseArr) {
        this.sparseArr = sparseArr;
    }

    public List<Integer> getSparseArr() {
        return sparseArr;
    }

    SparseVector(int[] nums) {
       // SparseVector v1= new SparseVector();
        List<Integer> sparseArr = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            sparseArr.add(nums[i]);
        }
        this.setSparseArr(sparseArr);

    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res=0;
        List<Integer> sparseArrV1 = this.getSparseArr();
        for(int i=0;i<vec.getSparseArr().size();i++){
           res +=  sparseArrV1.get(i) * vec.getSparseArr().get(i);
        }
        return res;
    }



}
