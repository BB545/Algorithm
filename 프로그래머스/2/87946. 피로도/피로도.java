class Solution {
    static int max = 0;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return max;
    }
    
    public static void dfs(int k, int cnt, int[][] dungeons) {
        max = Math.max(max, cnt);
        
        for (int i = 0; i < dungeons.length; i++) {
            int require = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if (!visited[i] && k >= require) {
                visited[i] = true;
                dfs(k - cost, cnt + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}