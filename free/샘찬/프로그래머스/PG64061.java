public class PG64061 {

    public static void main(String[] args) {

        int[][] board = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int result = new PG64061().solution(board, moves);

        System.out.println(result);
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] basket = new int[moves.length];
        int i = 0;
        for (int move : moves) {
            for (int[] list : board) {
                if (list[move - 1] != 0) {
                    basket[i] = list[move - 1];
                    if (i != 0 && basket[i] == basket[i - 1]) {
                        basket[i] = 0;
                        basket[i - 1] = 0;
                        i -= 2;
                        answer += 2;
                    }
                    list[move - 1] = 0;
                    i++;
                    break;
                }
            }
        }
        return answer;
    }
}
