import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M, V;
    static List<Integer> dfsResult;
    static List<Integer> bfsResult;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        dfsResult = new ArrayList<>();
        bfsResult = new ArrayList<>();
        
        visited = new boolean[N + 1];
        dfs(V);
        printResult(dfsResult);
        System.out.println();
        
        visited = new boolean[N + 1];
        bfs(V);
        printResult(bfsResult);
    }
    
    public static void dfs (int node) {
        visited[node] = true;
        dfsResult.add(node);
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        } 
    }
    
    public static void bfs (int start) {
        Queue<Integer> que = new LinkedList<>();
        
        que.add(start);
        visited[start] = true;
        bfsResult.add(start);
        
        while(!que.isEmpty()) {
            int node = que.poll();
            
            for (int next : graph[node]) {
                if (!visited[next]) {
                    que.add(next);
                    visited[next] = true;
                    bfsResult.add(next);
                }
            }
        }
    }
    
    public static void printResult(List<Integer> result) {
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}