import java.util.*;
public class QuickSort {
    static int partition(int a[], int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return i + 1;
    }

    // Deterministic Quick Sort
    static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int p = partition(a, low, high);
            quickSort(a, low, p - 1);
            quickSort(a, p + 1, high);
        }
    }

    // Randomized Quick Sort
    static void randomQuickSort(int a[], int low, int high) {
        if (low < high) {
            int r = low + (int)(Math.random() * (high - low + 1));
            int temp = a[r];
            a[r] = a[high];
            a[high] = temp;

            int p = partition(a, low, high);
            randomQuickSort(a, low, p - 1);
            randomQuickSort(a, p + 1, high);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = a[i];
        }

        quickSort(a, 0, n - 1);
        randomQuickSort(b, 0, n - 1);

        System.out.println("Deterministic Quick Sort:");
        System.out.println(Arrays.toString(a));
        System.out.println("Randomized Quick Sort:");
        System.out.println(Arrays.toString(b));
        sc.close();
    }
}
