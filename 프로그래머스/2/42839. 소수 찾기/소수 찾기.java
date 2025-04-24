import java.util.*;

class Solution {
    static Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        create("", numbers, visited);
        
        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void create(String current, String numbers, boolean[] visited) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                create(current + numbers.charAt(i), numbers, visited);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}