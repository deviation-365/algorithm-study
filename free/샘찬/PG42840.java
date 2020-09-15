package level1;

import java.util.Arrays;

public class PG42840 {

    public static void main(String[] args) {
        int[] result = new PG42840().solution(new int[]{1, 3, 2, 4, 2});
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] collects = {0, 0, 0};
        for (int i = 0; i < answers.length; i++) {
            if (first[i % first.length] == answers[i]) {
                collects[0]++;
            }
            if (second[i % second.length] == answers[i]) {
                collects[1]++;
            }
            if (third[i % third.length] == answers[i]) {
                collects[2]++;
            }
        }

        int resultSize = 1;
        int maxValue = collects[0];
        for (int i = 1; i < collects.length; i++) {
            if (collects[i] > maxValue) {
                resultSize = 1;
                maxValue = collects[i];
                continue;
            }
            if (maxValue == collects[i]) {
                resultSize++;
            }
        }
        int[] result = new int[resultSize];
        int resultIndex = 0;
        for (int i = 0; i < collects.length; i++) {
            if (collects[i] == maxValue) {
                result[resultIndex++] = i + 1;
            }
        }

        return result;
    }

}
