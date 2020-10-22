/**
    https://programmers.co.kr/learn/courses/30/lessons/12934
*/

class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        int sqrtInt = (int) sqrt;
        return sqrt == sqrtInt ? (long) Math.pow(sqrtInt + 1, 2) : -1;
    }
}
