import java.util.Scanner;
public class Fibonacci {
    static void iterative(int n){
        int a = 0, b = 1;
        System.out.print("Iterative: ");

        for (int i = 0; i < n; i++){
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }
    static int recursive(int n){
        if (n <= 1)
            return n;

        return recursive(n - 1) + recursive(n - 2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        iterative(n);

        System.out.print("Recursive: ");
        for (int i = 0; i < n; i++){
            System.out.print(recursive(i) + " ");
        }

        sc.close();
    }
}
