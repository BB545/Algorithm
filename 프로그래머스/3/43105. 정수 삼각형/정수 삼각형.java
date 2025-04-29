class Solution {
    public int solution(int[][] triangle) {
        int H = triangle.length;
        
        for (int i = H - 2; i >= 0; i--) { // 거꾸로 최댓값 갱신, 누적합 저장, i를 마지막에서 2번째줄부터 시작
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]); // 마지막줄 누적합 기본값으로 활용하기 위해
            }
        }
        return triangle[0][0]; // 최상위 노드가 최댓값
    }
}