/**
    https://programmers.co.kr/learn/courses/30/lessons/12916?language=java
*/

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        
        int withoutPLength = s.replace("p", "").length();
        int withoutYLength = s.replace("y", "").length();

        return withoutPLength == withoutYLength;
    }
}