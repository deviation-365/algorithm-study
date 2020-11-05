/**
* 3진법 뒤집기
* https://programmers.co.kr/learn/courses/30/lessons/68935
*/

class Solution {
    public int solution(int n) {
        int answer = 0;
        //3진수의 최대 자릿수의 값를 구할 변수
        int digit = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            //나머지를 계속 붙여 나감 
            //원래 3진수를 구하려면 나머지를 모두 구하고 마지막에 계산된 나머지부터 위로 올라가는 거지만 여기선 역으로 받아야 하기 때문에 바로 넣어줌
            int value = n % 3;
            sb.append(value);
            // 3보다 작으면 반복문 빠져나옴
            if (n < 3) break;
            n /= 3;
            //나눌 때 마다 자릿수의 값을 증가시킴
            digit *= 3;
        }
        //문자열을 한글자씩 배열로 만듬
        String[] arr = sb.toString().split("");
        for (String s : arr) {
            //한 글자씩 자릿수에 맞게 더해줌
            answer += Integer.parseInt(s) * digit;
            digit /= 3;
            
        }
        
        return answer;
    }
}
