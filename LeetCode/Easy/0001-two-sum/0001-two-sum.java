class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int op = target - nums[i];
            if (map.containsKey(op)) {
                return new int[] {map.get(op), i};
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}