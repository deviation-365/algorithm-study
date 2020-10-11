/**
 * https://programmers.co.kr/learn/courses/30/lessons/12930
*/

class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 문자열을 캐릭터 배열로 만듬
        char[] arr = s.toCharArray();
        // 문장안의 문자열을 위한 인덱스 선언
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            // 문자가 빈문자면 인덱스를 0으로 만듬 (문자 시작마다 인덱스를 0으로 하기 위함)
            if (arr[j] == ' ') {
                i = 0;
                continue;
            }
            // 짝수 인덱스(0포함)일 시 아스키코드 범위가 소문자 내에 있으면 -32 를 하여 대문자로 변경
            if (i % 2 == 0) {
                if (arr[j] >= 97 && arr[j] <= 122) {
                    arr[j] -= 32;
                }
            // 홀수 인덱스일시 아스키 코드 범위가 대문자 내에 있으면 +32 를하여 소문자로 변경
            } else {
                if (arr[j] >= 65 && arr[j] <= 90) {
                    arr[j] += + 32;
                }
            }
            i++;
        }
        // 캐릭터 배열을 문자열로 변경 후 반환
        return new String(arr);
    }
}