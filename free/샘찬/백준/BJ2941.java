/**
    https://www.acmicpc.net/problem/2941
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] croatia = new String[] { "dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=" };
        String input = scanner.nextLine();
        String temp;
        int answer = 0;
        String prev = "";
        for (String s: croatia) {
            temp = input;
            input = input.replace(s, " ");
            if (!prev.equals(input)) {
                answer += (temp.replace(" ", "").length() - input.replace(" ", "").length()) / s.length();
            }
            prev = input;
        }
        answer += input.replace(" ", "").length();
        System.out.println(answer);
    }
}
