import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        ArrayList<String> answerList = new ArrayList<>();
        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));
        
        answerList.add("ICN");
        boolean[] visited = new boolean[tickets.length];
        
        dfs("ICN", tickets, visited, answerList, 0);
        
        return answerList.toArray(new String[0]);
    }
    
    public boolean dfs(String current, String[][] tickets, boolean[] visited, ArrayList<String> answerList, int depth) {
        if (depth == tickets.length) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                answerList.add(tickets[i][1]);
                visited[i] = true;
                
                if (dfs(tickets[i][1], tickets, visited, answerList, depth + 1)) {
                    return true;
                }

                visited[i] = false;
                answerList.remove(answerList.size() - 1);
            }
        }
        return false;
    }
}