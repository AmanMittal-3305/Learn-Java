import java.util.*;

class prac1 {

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }

    public static void selectionSort(int[] arr) {
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 4, 6, 2, 1 };
        bubbleSort(arr);
        printArr(arr);
    }
}
