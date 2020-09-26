/**
    https://programmers.co.kr/learn/courses/30/lessons/12933
*/

import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        int digit = 1;
        long temp = 10L;
        while (temp < n) {
            temp *= 10;
            digit++;
        }
        long[] arr = new long[digit];
        for (int i = 0; i < digit; i++) {
            arr[i] = n % 10L;
            n = (n - arr[i]) / 10;
        }
        
        Arrays.sort(arr);
        temp = 1L;
        for (long a : arr) {
            long value = a * temp;
            answer += value;
            temp *= 10;
        }
        return answer;
    }
}