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
        int[] indexes = {0, 0, 0};
        int[] collects = {0, 0, 0};
        for (int answer : answers) {
            if (first[indexes[0]++] == answer) {
                collects[0]++;
            }
            if (second[indexes[1]++] == answer) {
                collects[1]++;
            }
            if (third[indexes[2]++] == answer) {
                collects[2]++;
            }
            if (indexes[0] == 5) indexes[0] = 0;
            if (indexes[1] == 8) indexes[1] = 0;
            if (indexes[2] == 10) indexes[2] = 0;
        }

        int[] clone = collects.clone();
        Arrays.sort(clone);
        int resultSize = 1;
        int maxValue = clone[2];
        for (int i = clone.length - 1; i > 0; i--) {
            if (maxValue == clone[i - 1]) {
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
