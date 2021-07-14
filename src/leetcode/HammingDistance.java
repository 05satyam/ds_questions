package leetcode;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int a = x^y , count = 0;
        while(a>0)
        {
            count += a&1;
            a>>=1;
        }
        return count;
    }
}
