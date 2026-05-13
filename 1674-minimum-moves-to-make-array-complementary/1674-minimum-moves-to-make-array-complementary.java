class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] diffArray = new int[2 * limit + 2];

        int length = nums.length;

        for(int i = 0; i < length / 2; i++){
            int left = nums[i];
            int right = nums[length - 1 - i];

            int min = Math.min(left, right);
            int max = Math.max(left, right);

            diffArray[min+1] -= 1;
            diffArray[max + limit + 1] += 1;

            diffArray[left + right] -= 1;
            diffArray[left + right + 1] += 1;
        }

        int count = length / 2;
        int current = count * 2;
        int result = Integer.MAX_VALUE;

        for(int i = 0; i <= 2 * limit; i++){
            current += diffArray[i];
            result = Math.min(result, current);
        }
        
        return result;
    }
}