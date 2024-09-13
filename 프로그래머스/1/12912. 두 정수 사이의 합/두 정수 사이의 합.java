class Solution {
    public long solution(int a, int b) {
        long sum = 0;
        int anum = 0;
        int bnum = 0;
        if (a < b) {
            anum = a;
            bnum = b;
        } else {
            anum = b;
            bnum = a;
        }
        
        for (long i = anum; i <= bnum; i++) {
            sum += i;
        }
        
        return sum;
    }
}