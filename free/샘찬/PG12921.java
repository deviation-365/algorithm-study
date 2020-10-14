/**
* https://programmers.co.kr/learn/courses/30/lessons/12921
*/

import java.util.Arrays;

class Solution {
    public int solution(int n) {
        //에라토스테네서의 체 사용
        //n + 1만큼 배열의 길이를 조정 (인덱스 0은 사용하지 않고 인덱스와 숫자를 동일시 하기 위함)
        boolean[] arr = new boolean[n + 1];
        //2부터 시작하여 i의 제곱이 n보다 작거나 같을 때 까지 순회
        for (int i = 2; i * i <= n; i++) {
            //요소의 값이 false이면  각 숫자의 배수를 true로 재할당 (배수라는 의미)
            if (!arr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = true;
                }
            }
        }
        //2부터 순회하면서 false면 카운트 증가
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (!arr[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}
