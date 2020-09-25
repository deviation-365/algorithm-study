/**
    https://programmers.co.kr/learn/courses/30/lessons/12948
*/

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        char[] arr = phone_number.toCharArray();
        
        for (int i = arr.length - 5; i >= 0 ; i--) {
            arr[i] = '*';
        }
        
        return new String(arr);
    }
}