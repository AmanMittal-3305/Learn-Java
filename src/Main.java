public class Main {

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public static int fibonnaci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonnaci(n - 1) + fibonnaci(n - 2);
    }

    public static boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int tiling(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return tiling(n - 1) + tiling(n - 2);
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean[] map) {
        if (idx == str.length()) {
            System.out.println(newStr.toString());
            return;
        }
        char c = str.charAt(idx);
        if (!map[c - 'a']) {
            map[c - 'a'] = true;
            newStr.append(c);
        }
        removeDuplicates(str, idx + 1, newStr, map);
    }

    public static int pairing(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return pairing(n - 1) + (n - 1) * pairing(n - 2);
    }

    public static void printAllOccurences(int[] arr, int key, int i) {
        if (i < arr.length) {
            if (arr[i] == key) {
                System.out.println(i);
            }
            printAllOccurences(arr, key, i + 1);
        }
    }

    public static void convertNumToString(String[] arr, StringBuilder sb, int num) {
        if (num == 0) {
            System.out.println(sb.toString());
            return;
        }
        int lastDigit = num % 10;
        num = num / 10;
        convertNumToString(arr, sb.insert(0, arr[lastDigit] + " "), num);
    }

    public static void main(String[] args) {
        // int fact = factorial(5);
        // System.out.println(fact);

        // int sum = sum(3);
        // System.out.println(sum);

        // int fib = fibonnaci(3);
        // System.out.println(fib);
        // System.out.println(fibonnaci(5));

        // int[] arr = { 5, 6, 9, 10, 12, 20 };
        // System.out.println(isSorted(arr, 0));

        // System.out.println(tiling(4));

        // String str = "appnnnaacollege";
        // StringBuilder newStr = new StringBuilder();
        // boolean[] map = new boolean[26];
        // removeDuplicates(str, 0, newStr, map);

        // int res = pairing(3);
        // System.out.println(res);

        // int[] arr = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
        // int key = 2;
        // printAllOccurences(arr, key, 0);

        String[] arr = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        convertNumToString(arr, new StringBuilder(""), 2019);
    }
}