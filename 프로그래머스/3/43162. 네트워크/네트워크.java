class Solution {
    private boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    
    public void dfs(int num, int[][] computers) {
        visited[num] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[num][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}