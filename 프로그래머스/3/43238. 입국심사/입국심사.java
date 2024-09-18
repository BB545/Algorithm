class Solution {
    public long solution(int n, int[] times) {
        long start = 0;
        long end = 1000000000 * 1000000000L;
        
        while(start < end) {
            long mid = (start + end) / 2;
            
            if (check(times, mid, n)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
    
    public boolean check(int[] times, long minutes, int n) {
        long sum = 0;
        
        for (int time : times) {
            sum += minutes / time;
        }
        
        return sum >= n;
    }
}