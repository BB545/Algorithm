import java.util.*;

class Solution {
    public String solution(int n) {
        String[] list = new String[n];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                list[i] = "수";
            } else {
                list[i] = "박";
            }
        }
        
        for (String word : list) {
            sb.append(word);
        }
        
        return sb.toString();
    }
}