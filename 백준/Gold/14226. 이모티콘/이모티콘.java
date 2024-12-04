import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        
        System.out.println(minimumTime(S));
    }
    
    public static int minimumTime(int S) {
        boolean[][] visited = new boolean[S + 1][S + 1];
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{1, 0, 0});
        visited[1][0] = true;
        
        while(!deque.isEmpty()) {
            int[] current = deque.poll();
            int screen = current[0];
            int clipboard = current[1];
            int time = current[2];
            
            if (screen == S) {
                return time;
            }
            
            if (!visited[screen][screen]) {
                visited[screen][screen] = true;
                deque.add(new int[]{screen, screen, time + 1}); // 복사
            }
            
            if (clipboard > 0 && screen + clipboard <= S && !visited[screen + clipboard][clipboard]) {
                visited[screen + clipboard][clipboard] = true;
                deque.add(new int[]{screen + clipboard, clipboard, time + 1}); // 붙여넣기
            }
            
            if (screen > 0 && !visited[screen - 1][clipboard]) {
                visited[screen - 1][clipboard] = true;
                deque.add(new int[]{screen - 1, clipboard, time + 1}); // 삭제
            }
        }
        return -1;
    }
}