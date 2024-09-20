class Solution {
    private static int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        return dfs(k, dungeons, visited, 0, 0);
    }
    
    public int dfs(int k, int[][] dungeons, boolean[] visited, int idx, int cnt) {
        if (dungeons.length == idx) {
            max = Math.max(max, cnt);
            return max;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            
            if (dungeons[i][0] <= k) {
                dfs(k - dungeons[i][1], dungeons, visited, idx + 1, cnt + 1);
            } else {
                dfs(k, dungeons, visited, idx + 1, cnt);
            }
            
            visited[i] = false;
        }
        return max;
    } 
}