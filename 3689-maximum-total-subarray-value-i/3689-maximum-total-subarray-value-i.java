class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int length = nums.length;

        int max = nums[0];
        int min = nums[0];

        for (int index = 1; index < length; index++) {
            max = Math.max(max, nums[index]);
            min = Math.min(min, nums[index]);
        }

        return (long) (max - min) * k;
    }
}