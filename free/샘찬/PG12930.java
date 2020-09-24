/**
    https://programmers.co.kr/learn/courses/30/lessons/12930
*/

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                i = 0;
                continue;
            }
            if (i % 2 == 0) {
                if (arr[j] >= 97 && arr[j] <= 122) {
                    arr[j] -= 32;
                }
            } else {
                if (arr[j] >= 65 && arr[j] <= 90) {
                    arr[j] += + 32;
                }
            }
            i++;
        }
        return new String(arr);
    }
}