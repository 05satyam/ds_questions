package leetcode;

public class NimGame {
    public boolean canWinNim(int n) {
        return (n & 0b11) != 0;
    }
}
