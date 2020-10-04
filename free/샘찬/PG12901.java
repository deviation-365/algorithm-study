/**
    https://programmers.co.kr/learn/courses/30/lessons/12901#
*/

class Solution {
    public String solution(int a, int b) {
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] dayArr = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        int dayCount = 0;
        for (int i = 0; i < a - 1; i++) {
            dayCount += dayArr[i];
        }
        return days[(dayCount + b - 1) % 7];
    }
}