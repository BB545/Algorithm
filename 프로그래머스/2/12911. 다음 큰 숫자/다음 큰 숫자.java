class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt1 = 0;
        String bin = Integer.toBinaryString(n);
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                cnt1++;
            }
        }
        
        for (int num = n + 1; num < 1000000; num++) {
            String bin2 = Integer.toBinaryString(num);
            int cnt2 = 0;
            for (int i = 0; i < bin2.length(); i++) {
                if (bin2.charAt(i) == '1') {
                    cnt2++;
                }
            }
            
            if (cnt1 == cnt2) {
                answer = num;
                break;
            }
        }
        return answer;
    }
}