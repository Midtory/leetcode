class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int mapIndex = 0;
        for(int num : nums){
            hashmap.put(num, mapIndex);
            mapIndex++;
        }
        for(int index = 0; index < nums.length; index++){
            int diff = target - nums[index];
            if(hashmap.containsKey(diff)){
                if(hashmap.get(diff) != index){
                    return new int[]{index, hashmap.get(diff)};
                }
            }
        }
        return new int[]{};
    }
}