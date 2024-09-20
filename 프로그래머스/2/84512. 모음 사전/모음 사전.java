import java.util.*;

class Solution {
    static List<String> wordList = new ArrayList<>();
    
    public int solution(String word) {
        dfs("");
        return wordList.indexOf(word);
    }
    
    public void dfs(String s) {
        if (s.length() > 5) return;
        
        wordList.add(s);
        
        for (int i = 0; i < 5; i++) {
            dfs(s + "AEIOU".charAt(i));
        }
    }
}