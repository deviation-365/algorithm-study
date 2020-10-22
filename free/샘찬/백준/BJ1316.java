/**
    https://www.acmicpc.net/problem/1316
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        String[] inputArr = new String[count];
        for (int i = 0; i < count; i++) {
            inputArr[i] = scanner.nextLine();
        }
        int result = count;
        for (String n : inputArr) {
            char[] arr = n.toCharArray();
            StringBuilder sb = new StringBuilder();
            char current = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (current != arr[i]) {
                    sb.append(current);
                    current = arr[i];
                }
                if (sb.toString().indexOf(arr[i]) != -1) {
                    result--;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
