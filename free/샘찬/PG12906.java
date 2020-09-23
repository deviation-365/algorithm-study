import java.util.*;

/**
    https://programmers.co.kr/learn/courses/30/lessons/12906
*/
public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        int[] array = new int[arr.length];
        int size = 0;
        array[size++] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] != arr[i]) {
                array[size++] = arr[i];
            }
        }
        
        return Arrays.copyOfRange(array, 0, size);
    }
}