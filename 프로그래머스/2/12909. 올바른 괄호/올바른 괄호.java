import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> que = new LinkedList<>();
        
        if (s.length() % 2 != 0) {
            answer = false;
        }
        for (char str : s.toCharArray()) {
            if (str == '(') {
                que.offer(str);
            } else {
                if (que.isEmpty()) {
                    answer = false;
                }
                que.poll();
            }
        }
        
        if (que.size() != 0) {
            answer = false;
        }
        
        return answer;
    }
}