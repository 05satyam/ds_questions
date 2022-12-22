package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchInGrid {


    public static boolean exists(char[][] board, boolean[][] visited, int i, int j, int maxI, int maxJ, StringBuilder res, String word) {
        if (res.toString().equalsIgnoreCase(word))
            return true;
        visited[i][j] = true;
        boolean downMove = false;
        if (i < maxI) {
            downMove = exists(board, visited, i + 1, j, maxI, maxJ, res.append(board[i + 1][j]), word);
        }
        boolean rightMove = false;
        if (j < maxJ) {
            rightMove = exists(board, visited, i, j + 1, maxI, maxJ, res.append(board[i][j + 1]), word);
        }

        return rightMove || downMove;
    }

    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int maxI = board.length;
                int maxJ = board[i].length;
                boolean visited[][] = new boolean[board.length][board[i].length];
                StringBuilder res = new StringBuilder();
                res.append(board[i][j]);
                if (exists(board, visited, i, j, maxI, maxJ, res, word)) ;
                return true;
            }
            return false;
        }
        return false;
    }
        public static void main (String[]a){
            char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

            String word = "ABCCED";

            //System.out.println(exist(board, word));
            hash("bvvv");
            hash("xxxw");
        }

        public static void hash(String s){
        int hash=0;
        for(int i=0;i<s.length();i++){
            hash+=(i+1)* (s.charAt(i)-'a'+1);

        }

            System.out.println(hash);
        }


    public static int countGoodStrings(int min_length, int max_length, int one_group, int zero_group) {
        // Write your code here
        int count = 0;
        Set<String> setC = new HashSet<>();
        for (int i = min_length; i <= max_length; i++)
        {
            String str = "";


            for (int j = 0; j < i; j++)
                str += "0";


            while (true)
            {


                boolean flag = true;
                int zc = 0, oc = 0;

                for (int j = 0; j < str.length(); j++)
                {

                    if (str.charAt(j) == '1')
                    {
                        if (oc == one_group)
                        {
                            flag = false;
                            break;
                        }
                        oc = 0;
                        zc = 0;
                    }
                    else
                    {
                        if (zc == zero_group)
                        {
                            flag = false;
                            break;
                        }
                        zc = 0;
                        oc = 0;
                    }


                    if (str.charAt(j) == '0')
                        zc++;

                    if (str.charAt(j) == '1')
                        oc++;
                }


                if (flag)
                    count++;


                if (str.charAt(0) == '1')
                    break;


                int k = i - 1;
                while (k >= 0)
                {
                    if (str.charAt(k) == '1')
                    {
                        StringBuffer string = new StringBuffer(str);
                        string.setCharAt(k, '0');
                        str=string.toString();
                        setC.add(str);
                        k--;
                    }
                    else
                    {

                        StringBuffer string = new StringBuffer(str);
                        string.setCharAt(k, '1');
                        str=string.toString();
                        setC.add(str);
                        break;
                    }
                }
            }
        }

        return setC.size();
    }


    public static long getMaximumScore(List<Integer> arr, int k) {
        // Write your code here
        long count=0,sum=0;
        int n= arr.size();
        int[] array = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) array[i] = arr.get(i);
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(array[j+1]>array[j])
                {
                    array[j+1]=array[j+1]+array[j];
                    array[j]=array[j+1]-array[j];
                    array[j+1]=array[j+1]-array[j];
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(count==k)
                return sum;
            else
            {
                sum=sum+array[i];
                count++;
            }
        }
        return count;
    }

}
