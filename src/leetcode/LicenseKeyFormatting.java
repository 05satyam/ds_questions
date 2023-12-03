package leetcode;

/**
 * You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.
 *
 * We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.
 *
 * Return the reformatted license key.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "5F3Z-2e-9-w", k = 4
 * Output: "5F3Z-2E9W"
 * Explanation: The string s has been split into two parts, each part has 4 characters.
 * Note that the two extra dashes are not needed and can be removed.
 * Example 2:
 *
 * Input: s = "2-5g-3-J", k = 2
 * Output: "2-5G-3J"
 * Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of English letters, digits, and dashes '-'.
 * 1 <= k <= 104
 */

//O(n⋅k) in the worst case, but if  k is constant, it is  O(n).

class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {


        int n = s.length();
        int count=k;
        StringBuilder res = new StringBuilder();
        StringBuilder sbS =  new StringBuilder();
        for(int i=n-1;i>=0;){

            while(count>0 && i>=0){

                if(s.charAt(i)=='-'){
                    i--;
                    continue;
                }
                sbS.insert(0, s.charAt(i));
                i--;
                count--;
                //System.out.println("sbS "+ sbS.toString());
            }

            if(count==0){
                count=k;
                res.insert(0,sbS.toString().toUpperCase());

                res.insert(0, "-");

                sbS = new StringBuilder();
            }
        }
        if(sbS.length()>0)
            res.insert(0, sbS.toString().toUpperCase());
        //res.insert(0, String.valueOf(s.charAt(0)).toLowerCase());
        if(res.length()<1)
            return "";
        String ress = res.toString();;
        if(ress.charAt(0)=='-')
            ress = ress.substring(1);
        return ress;
    }
}