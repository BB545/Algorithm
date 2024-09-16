import java.util.*;

class Solution {
    class Node {
        String word;
        int count;
        
        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Node> que = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        que.offer(new Node(begin, 0));
        
        while(!que.isEmpty()) {
            Node node = que.poll();
            if (node.word.equals(target)) return node.count;
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && count(node.word, words[i])) {
                    que.offer(new Node(words[i], node.count + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    public boolean count(String begin, String word) {
        int cnt = 0;
        for (int j = 0; j < word.length(); j++) {
            if (begin.charAt(j) != word.charAt(j)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}