package mix_questions;
import java.util.Scanner;


public class Book {
    String bookName;
    int pageNumber;
    String authorName;

    //empty constructors
    Book(){

        //empty

    }

    //method
    public void testMethod(Book bookObj1, Book obj2){
        this.bookName = "new book";
        System.out.println(this.bookName);
        System.out.println(this);

        if(this.bookName == bookObj1.bookName){

        }

        if(obj2.bookName == bookObj1.bookName){

        }
    }

    //parametrized constructor
    Book(String newBookName, String newAuthorName, int newPageNumber){
        this.bookName = newBookName;
        this.authorName = newAuthorName;
        this.pageNumber = newPageNumber;
    }


    public static void main(String aq[]){
        Scanner inputObj = new Scanner(System.in);
        int a[]=new int[6];    //declaration and instantiation
        a[0]=10;//  a single integer value  1001
        a[1]=20;   //1003
        a[2]=70;  //1005
        a[3]=40;  //1007
        a[4]=50;  //1009
        //traversing array
        System.out.println(a.length);
        for(int i=0;i<a.length;i++)//length is the property of array
            System.out.println("a["+i+"] "+ a[i]);


        int arr2DArray[][] = new int[2][2];

        int arr[][]={
                {1,2,3},{2,4,5},{4,4,5}
                };

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


        System.out.println();
        //store database
        Book[] bookArray = new Book[2];
        int i=0;
        while(i<2){
            System.out.println("enter a book name");
            String bookName = inputObj.nextLine();
            System.out.println("enter a author name ");
            String authorName = inputObj.nextLine();
            System.out.println("enter page name: ");
            int pageNo = inputObj.nextInt();


            bookArray[i] = new Book(bookName, authorName, pageNo);
            i++;

            inputObj.nextLine();
        }


        i=0;
        while(i<2){
            System.out.println("book" + i + ": "+ bookArray[i].bookName + " ,"+ bookArray[i].authorName + " ,"+ bookArray[i].pageNumber) ;
            i++;

        }

    }
}

