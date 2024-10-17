import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        
        Queue<Integer> que = new LinkedList<>();
        int LastP = -1;
        
        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();
            
            switch (command) {
                case "pop":
                    Integer p = que.poll();
                    System.out.println(p == null ? -1 : p);
                    break;
                case "size":
                    System.out.println(que.size());
                    break;
                case "empty":
                    System.out.println(que.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(que.isEmpty() ? -1 : que.peek());
                    break;
                case "back":
                    if (que.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(LastP);
                    }
                    break;
                default:
                    String[] parts = command.split(" ");
                    if (parts[0].equals("push")) {
                        int value = Integer.parseInt(parts[1]);
                        que.add(value);
                        LastP = value;
                    }
                    break;
            }
        }
        sc.close();
    }
}