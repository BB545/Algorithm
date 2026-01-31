class Solution {
    public int removeDuplicates(int[] nums) {
        int front = 0;
        int back = 1;
        int cnt = 1;

        while (back < nums.length) {
            if (nums[front] != nums[back]) {
                nums[front + 1] = nums[back];
                front++;
                back++;
                cnt++;
            } else {
                back++;
            }
        }

        return cnt;
    }
}