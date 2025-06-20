import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> people = new HashMap<>();
        
        for (String name : participant) { // 이름 중복 포함 저장 위해 count
            people.put(name, people.getOrDefault(name, 0) + 1);
        }
        
        for (String name : completion) {
            if (people.containsKey(name)) {
                people.put(name, people.get(name) - 1);
            }
        }
        
        for (String name : participant) {
            if (people.get(name) != 0) {
                return name;
            }
        }
        
        return "none";
    }
}