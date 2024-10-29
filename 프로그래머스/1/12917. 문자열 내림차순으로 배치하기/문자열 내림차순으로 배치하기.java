import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] str = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            str[i] = s.charAt(i);
        }
        
        Arrays.sort(str);
        
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(str[i]);
        }
        
        return sb.toString();
    }
}