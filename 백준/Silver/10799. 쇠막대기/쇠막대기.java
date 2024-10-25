import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                
                if (input.charAt(i - 1) == '(') {
                    cnt += stack.size();
                } else {
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}