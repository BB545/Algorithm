class Solution {
    public int[] solution(int brown, int yellow) {
        int size = brown + yellow;
        int[] answer = new int[2];
        int w = 0;
        
        for (int h = 1; h < size + 1; h++) {
            
            if (size % h == 0) {
                w = size / h;
            }
            
            if (w > 2 && h > 2 && (w - 2) * (h - 2) == yellow && w >= h) {
                answer[0] = w;
                answer[1] = h;
            }
        }
        return answer;
    }
}