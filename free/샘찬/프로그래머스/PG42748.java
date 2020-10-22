package level1;

import java.util.Arrays;

public class PG42748 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = 	{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = new PG42748().solution(array, command);
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int a = 0;
        for (int[] command : commands) {
            int len = command[1] - command[0] + 1;
            int[] arr = new int[len];
            int index = 0;
            for (int i = command[0] - 1; i < command[1]; i++) {
                arr[index++] = array[i];
            }
            Arrays.sort(arr);
            answer[a++] = arr[command[2] - 1];
        }

        return answer;
    }

}
