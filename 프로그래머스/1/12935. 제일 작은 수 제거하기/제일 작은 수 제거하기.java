import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answerList = new ArrayList<>();
        int[] sortedarr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedarr);
        int num = sortedarr[0];
        
        for (int a : arr) {
            if(a != num) {
                answerList.add(a);
            }
        }
        
        if (answerList.isEmpty()) {
            answerList.add(-1);
        }
        
        int[] answer = answerList.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}