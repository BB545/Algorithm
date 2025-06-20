import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> kind = new HashMap<>();
        int cnt = 1;
        
        for (String[] cloth : clothes) {
            String key = cloth[1];
            kind.put(key, kind.getOrDefault(key, 0) + 1);
        }
        
        for (int val : kind.values()) {
            cnt = cnt * (val + 1);
        }
        
        return cnt - 1;
    }
}