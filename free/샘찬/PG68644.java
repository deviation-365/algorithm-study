import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG68644 {

    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] result = new PG68644().solution(numbers);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 1;
        while (left != numbers.length - 2) {
            if (right == numbers.length) {
                left++;
                right = left + 1;
            }
            int sum = numbers[left] + numbers[right];
            if (list.indexOf(sum) == -1) {
                list.add(sum);
            }
            right++;
        }

        return list.stream().sorted().mapToInt(i -> i).toArray();
    }

}
