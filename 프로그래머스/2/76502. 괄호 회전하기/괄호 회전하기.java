import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String rotatedStr = s.substring(i) + s.substring(0, i);
            Stack<Character> stack = new Stack<>();
            
            for (char c : rotatedStr.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }
                
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                    continue;
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                    continue;
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                
                stack.push(c);
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}