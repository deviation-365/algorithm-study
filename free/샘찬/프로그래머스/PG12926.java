/**
  https://programmers.co.kr/learn/courses/30/lessons/12926?language=java
*/

class Solution {

    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        String result = new Solution().solution(s, n);
        System.out.println(result);
    }

    public String solution(String s, int n) {
        char[] cArr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                cArr[i] = c;
                continue;
            }
            int sum = c + n;
            if (c <= 90 && sum > 90 || sum > 122) {
                cArr[i] = (char) (sum - 26);
                continue;
            }
            cArr[i] = (char) sum;
        }
        return new String(cArr);
    }

}