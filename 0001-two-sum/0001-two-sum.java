class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int op = target - nums[i];
            if (map.containsKey(op)) {
                answer[0] = map.get(op);
                answer[1] = i;
            }
            map.put(nums[i], i);
        }

        return answer;
    }
}