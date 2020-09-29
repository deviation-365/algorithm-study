/**
https://programmers.co.kr/learn/courses/30/lessons/12940
*/

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int smaller = n;
        int bigger = m;
        if (n > m) {
            bigger = n;
            smaller = m;
        }
        
        int max = 0;
        for (int i = 1; i <= smaller; i++) {
            if (bigger % i == 0 && smaller % i == 0) {
                max = i;
            }
        }
        answer[0] = max;
        int start = bigger / max;
        for (int i = start; i <= bigger * smaller; i++) {
            if ((i * max % bigger == 0) && (i * max % smaller == 0)) {
                answer[1] = i * max;
                break;
            }
        }
        
        return answer;
    }
}
