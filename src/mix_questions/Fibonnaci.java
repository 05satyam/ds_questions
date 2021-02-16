package mix_questions;

public class Fibonnaci {
    static int count = 2;

    static void printFibonaciiUsingRecursion(int n) {
        if (n == 1) {
            System.out.print("1 ");
            return;
        }

        if (n == 2) {
            System.out.print("1 1");
            return;
        }
        int a = 1, b = 1;
        System.out.print(a + " " + b + " ");
        printFibonaci(n, a, b);

    }

    static void printFibonaci(int n, int a, int b) {
        if (count == n)
            return;
        int c = a + b;
        count++;
        System.out.print(c + " ");
        printFibonaci(n, b, c);

    }

    public static void main(String a[]) {
        printFibonaciiUsingRecursion(5);
    }
}
