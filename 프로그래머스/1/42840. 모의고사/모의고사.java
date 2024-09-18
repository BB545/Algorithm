import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] s1 = new int[]{1,2,3,4,5};
        int[] s2 = new int[]{2,1,2,3,2,4,2,5};
        int[] s3 = new int[]{3,3,1,1,2,2,4,4,5,5};
        
        List<Integer> score = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (s1[i % s1.length] == answers[i]) {
                cnt1++;
            }
            if (s2[i % s2.length] == answers[i]) {
                cnt2++;
            }
            if (s3[i % s3.length] == answers[i]) {
                cnt3++;
            }
        }
        
        score.add(cnt1);
        score.add(cnt2);
        score.add(cnt3);
        
        int max = Collections.max(score);
        
        for (int i = 0; i < score.size(); i++) {
            if (max == score.get(i)) {
                ans.add(i + 1);
            }
        }
        
        return ans.stream().mapToInt(i -> i).toArray();
    }
}