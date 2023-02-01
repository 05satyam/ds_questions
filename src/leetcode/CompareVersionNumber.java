/**
 * Given two version numbers, version1 and version2, compare them.
 *
 * Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.
 *
 * To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.
 *
 * Return the following:
 *
 * If version1 < version2, return -1.
 * If version1 > version2, return 1.
 * Otherwise, return 0.
 *
 *
 * Example 1:
 *
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
 */
package leetcode;

public class CompareVersionNumber {
    public int compareVersion(String version1, String version2) {

        String[] v1= version1.split("\\.");
        String[] v2= version2.split("\\.");
        int v1Len=v1.length, v2Len=v2.length;
        int i=0, j=0;

        while(i<v1Len && j<v2Len){
            System.out.println("v1_i "+ v1[i] + "  v2_j "+ v2[j] );
            if(Integer.valueOf(v1[i])>Integer.valueOf(v2[j]))
                return 1;
            if(Integer.valueOf(v1[i])<Integer.valueOf(v2[j]))
                return -1;

            i++;
            j++;
        }

        if(i<v1Len){
            while(i<v1Len){
                if(Integer.valueOf(v2[i])!=0)
                    return 1;
                i++;
            }
        }

        if(j<v2Len){
            while(j<v2Len){
                if(Integer.valueOf(v1[j])!=0)
                    return -1;
                j++;
            }
        }

        return 0;
    }

    public static void main(String[] s){
        CompareVersionNumber obj = new CompareVersionNumber();

        System.out.println(obj.compareVersion("1", "1.1"));
    }
}
