class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        int cnt0 = 0;
        
        while (!s.equals("1")) {
            int cnt1 = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    cnt1++;
                } else {
                    cnt0++;
                }
            }
            
            s = Integer.toBinaryString(cnt1);
            cnt++;
            
            if (s.equals("1")) break;
        }
        
        answer[0] = cnt;
        answer[1] = cnt0;
        
        return answer;
    }
}