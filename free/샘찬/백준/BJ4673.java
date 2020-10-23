/**
    https://www.acmicpc.net/problem/4673
*/

public class Main {

    public static void main(String[] args) {
        int n = 10000;
        int[] arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int selfNumber = getSelfNumber(i + 1);
            if (selfNumber <= n) {
                arr[selfNumber] = 0;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }
    }

    public static int getSelfNumber(int num) {
        int sum = num;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
