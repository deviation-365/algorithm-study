/**
	https://www.acmicpc.net/problem/1065
*/

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 100) {
                answer++;
                continue;
            }
            String[] arr = String.valueOf(i).split("");
            double diff = 0;
            double diffSum = 0;
            for (int j = 1; j < arr.length; j++) {
                diff = Integer.parseInt(arr[j]) - Integer.parseInt(arr[j - 1]);
                diffSum += diff;
            }
            if (diffSum / (arr.length - 1) == diff) {
                answer++;
            }
        }
        System.out.print(answer);
    }
}