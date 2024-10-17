import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        
        List<Integer> result = new ArrayList<>();
        backtrack(arr, result, visited, N);
    }
    
    public static void backtrack(int[] arr, List<Integer> result, boolean[] visited, int N) {
        if (result.size() == N) {
            for (int num : result) {
                System.out.print(num + " ");
            };
            System.out.println();
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result.add(arr[i]);
                
                backtrack(arr, result, visited, N);
                
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }
}