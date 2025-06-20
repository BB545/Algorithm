import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> poket = new HashMap<>();
        int N = 0;
        
        for (int num : nums) {
            N++;
            poket.put(num, poket.getOrDefault(num, 0) + 1);
        }
        
        if (poket.size() >= N / 2) {
            return N / 2;
        } else {
            return poket.size();
        }
    }
}