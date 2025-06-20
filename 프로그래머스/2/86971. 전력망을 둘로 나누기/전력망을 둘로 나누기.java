import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            
            for (int j = 0; j <= n; j++) { // 그래프 노드 1부터 시작 = n + 1개로 만들어주기
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
        boolean[] visited = new boolean[n + 1]; // 노드가 1부터 시작
        Queue<Integer> que = new LinkedList<>();
        visited[start] = true;
        int cnt = 1;
        que.add(start);
        
        while (!que.isEmpty()) {
            int x = que.poll();
            
            for (int next : graph.get(x)) {
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