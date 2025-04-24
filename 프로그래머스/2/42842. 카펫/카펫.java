class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int size = brown + yellow;
        
        for (int height = 3; height <= size / height; height++) {
            int width = size / height;
            
            if (size % height == 0) {
                int inner = (width - 2) * (height - 2);
                
                if (inner == yellow) {
                    answer = new int[]{width, height};
                }
            }
        }
        return answer;
    }
}