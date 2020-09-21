import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

/**
  https://programmers.co.kr/learn/courses/30/lessons/12915
*/

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Map<Character, String> map = new HashMap<>();
        
        for (int i = 0; i < strings.length; i++) {
            char key = strings[i].charAt(n);
            String string = map.get(key);
            if (string == null) {
                map.put(key, strings[i]);
            } else {
                map.put(key, string + "," + strings[i]);
            }
        }
        Set<Character> keys = map.keySet();
        List<Character> keys2 = new ArrayList<>(keys);
        Collections.sort(keys2);
        
        int i = 0;
        for (Character key : keys2) {
            String value = map.get(key);
            if (value.contains(",")) {
                String[] arr = value.split(",");
                Arrays.sort(arr);
                for (String s : arr) {
                    answer[i++] = s;
                }
                continue;
            }
            answer[i++] = value;
        }
        return answer;
    }
}