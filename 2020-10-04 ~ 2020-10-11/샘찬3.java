/**
    https://leetcode.com/problems/two-sum/submissions/
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // 예시)
        // [ 2, 7, 11, 15 ]
        // [ i, j, 11, 15 ] // i는 처음부터 시작, j는 i보다 1 큰 수부터 시작
        // [ i, 7,  j, 15 ]
        // [ i, 7, 11,  j ] // j가 배열의 끝에 도달했으므로 i++
        // [ 2, i,  j, 15 ] // j는 i보다 1이 큰 값부터 시작 (반복)

        // i와 j는 겹치지 않게 움직여야한다 j가 최대 length - 1만큼 가기 때문에 i는 최대 length - 2 움직인다.
        for (int i = 0; i < nums.length - 1; i++) {
            // j도 마찬가지로 i와 겹치지 않아야 하기 때문에 i + 1부터 시작한다.
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) { // i번째와 j번째의 합이 target과 같으면 리턴
                    return new int[] { i, j };
                }
            }
        }
        //답이 무조건 있다는 전제가 있기 때문에 null을 리턴해도 상관 없음 (반복문 안에서 무조건 끝나기 때문에)
        return null;
    }
}