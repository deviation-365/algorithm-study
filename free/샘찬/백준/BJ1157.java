/*
 * https://www.acmicpc.net/problem/1157
 * */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toUpperCase();
        char[] arr = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        // 순회하면서 이미 존재하는 문자인 경우 갯수를 1증가시킴
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int max = 0;
        int maxValue = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            // 순회하면서 최대 값보다 큰 값일 시 key, value 를 각각 max, maxValue에 담음
            if (entry.getValue() > maxValue) {
                max = entry.getKey();
                maxValue = entry.getValue();
            // 최대 값과 같은 값일 시 key의 int 값를 추가로 더함
            } else if (entry.getValue() == maxValue) {
                max += entry.getKey();
            }
        }
        // 대문자 아스키코드의 범위가 65 ~ 90 이므로 두개 이상일시 90을 초과하여 키가 여러개 존재한다고 판단
        if (max > 90)
            System.out.println("?");
        else
            System.out.println((char) max);
    }

}
