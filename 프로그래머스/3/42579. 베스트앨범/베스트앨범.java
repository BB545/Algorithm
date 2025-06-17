import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        for (Map.Entry<String, Integer> entry : entryList) {
            String Key = entry.getKey();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            for (int i = 0; i < plays.length; i++) {
                if (genres[i].equals(Key)) {
                    pq.add(new int[]{i, plays[i]});
                }
            }
            
            for (int i = 0; i < 2 && !pq.isEmpty(); i++) {
                int[] item = pq.poll();
                answer.add(item[0]);
            }
        }
    
        int[] array = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            array[i] = answer.get(i);
        }
    
        return array;
    }
}