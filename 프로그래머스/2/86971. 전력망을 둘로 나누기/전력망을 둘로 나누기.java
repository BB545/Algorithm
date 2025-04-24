import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }
            
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                
                int a = wires[j][0];
                int b = wires[j][1];
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            int cnt = bfs(graph, n, wires[i][0]);
            int diff = Math.abs(n - 2 * cnt);
            min = Math.min(min, diff);
        }
        
        return min;
    }
    
    public static int bfs(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n + 1]; // 송전탑 번호 1부터 시작
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        int cnt = 1;
        
        while (!que.isEmpty()) {
            int current = que.poll();
            
            for (int next : graph.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    que.add(next);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}