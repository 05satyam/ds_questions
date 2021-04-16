package mix_questions;

public class ArrayClass {


    public static void main(String args[]) {
//declaring and initializing 2D array
        int arr[][] = {{1, 2, 3}, {2, 4, 5}, {4, 4, 5}};
//printing 2D array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("arr[" + i+"]["+j+"] "+arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("arr[" + j+"]["+i+"] "+arr[j][i] + " ");
            }
            System.out.println();
        }
    }
}

/*
i=0---->
       j--> 0,1,2
i=1----->
         j=0,1,2

i=2------>

         j=0,1,2

*/
