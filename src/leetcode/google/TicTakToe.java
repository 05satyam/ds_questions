/**
 * Players take turns placing characters into empty squares ' '.
 * The first player A always places 'X' characters, while the second player B always places 'O' characters.
 * 'X' and 'O' characters are always placed into empty squares, never on filled ones.
 * The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
 * The game also ends if all squares are non-empty.
 * No more moves can be played if the game is over.
 * Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
 *
 * You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.
 *
 *
 * Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * Output: "A"
 * Explanation: A wins, they always play first.
 *
 *
 */
package leetcode.google;

public class TicTakToe {
    public static String tictactoe(int[][] moves) {
        int m=moves.length;
        int n=moves[0].length;
        int board[][]=new int[3][3];
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
               board[i][j]=-1;
            }
        }
        int chance=0;
        for(int i=0;i<m;i++){
            int r=moves[i][0];
            int c=moves[i][1];
            if(chance==0){
                board[r][c]=1;
                chance=1;
            }else {
                board[r][c]=2;
                chance=0;
            }
        }

        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        //main diagnoal check
        int count=0;
        int countA=0;
        int countB=0;
        for(int i=0;i<3;i++){
            if(board[i][i]==1)
                countA++;
            if(board[i][i]==2)
                countB++;
        }
        if(countA==3)
            return "A";
        if(countB==3)
            return "B";



        // second diagonal
        int col=2;
        countA=0;
        countB=0;
        for(int i=0;i<3;i++){
            if(board[i][col]==1) {
                countA++;
                col--;
            }

        }
        col=2;
        countB=0;
        for(int i=0;i<3;i++){

            if(board[i][col]==2) {
                countB++;
                col--;
            }
        }


        if(countA==3)
            return "A";
        if(countB==3)
            return "B";

        count=0;


        // check m col
        count=0;
        for(int i=0;i<3;i++){
            int a=board[0][i];
            int b=board[1][i];
            int c=board[2][i];

            if(a==1 && a==b && b==c)
                return "A";
            if(a==2 && a==b && b==c)
                return "B";
        }



        // check m row
        count=0;
        for(int i=0;i<3;i++){
            int a=board[i][0];
            int b=board[i][1];
            int c=board[i][2];

            if(a==1 && a==b && b==c)
                return "A";
            if(a==2 && a==b && b==c)
                return "B";
        }

        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(board[i][j]==-1)
                    return "Pending";
            }
        }
        return "Draw";
    }


    public static void main(String[] a){
        int moves[][] = {{0,0},{1,1},{2,0},{1,0},{1,2},{2,1},{0,1},{0,2},{2,2}};

        System.out.println(tictactoe(moves));

    }
}
