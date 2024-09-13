import java.util.*;

class Solution {
    public long solution(long n) {
        List<String> arr = new ArrayList<>();
        while(n > 10) {
            long a = n%10;
            arr.add(Long.toString(a));
            n = n/10;
        }
        arr.add(Long.toString(n));
        
        Collections.sort(arr, Collections.reverseOrder());
        
        String result = "";
        for (String num : arr) {
            result += num;
        }
        
        return Long.parseLong(result);
    }
}