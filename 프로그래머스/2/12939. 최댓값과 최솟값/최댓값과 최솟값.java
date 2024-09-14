import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        List<Integer> slist = new ArrayList<>();
        for (String num : strArr) {
            slist.add(Integer.parseInt(num));
        }
        Collections.sort(slist);
        
        int slistLen = slist.size() - 1;
        int max_value = slist.get(slistLen);
        int min_value = slist.get(0);
        
        return Integer.toString(min_value) + " " + Integer.toString(max_value);
    }
}