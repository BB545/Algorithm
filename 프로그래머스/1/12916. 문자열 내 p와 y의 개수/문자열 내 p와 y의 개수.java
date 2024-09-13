class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pcnt = 0;
        int ycnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i+1).equalsIgnoreCase("p")) {
                pcnt += 1;
            }
            if (s.substring(i, i+1).equalsIgnoreCase("y")) {
                ycnt += 1;
            }
        }
    
        if (pcnt!=ycnt) {
            answer = false;
        }

        return answer;
    }
}