import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] graph;
    static int[] colors;
    static int K, V, E;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine().trim());
        
        while(K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[V + 1];
            colors = new int[V + 1];
            
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine().trim());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
            
            if (isBipartite()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    public static boolean isBipartite() {
        for (int i = 1; i <= V; i++) {
            if (colors[i] == 0) {
                if (!bfs(i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        colors[start] = 1;
        que.add(start);
        
        while(!que.isEmpty()) {
            int current = que.poll();
            
            for (int neighbor : graph[current]) {
                if (colors[neighbor] == 0) {
                    colors[neighbor] = -colors[current];
                    que.add(neighbor);
                } else if (colors[neighbor] == colors[current]) {
                    return false;
                }
            }
        }
        return true;
    }
}