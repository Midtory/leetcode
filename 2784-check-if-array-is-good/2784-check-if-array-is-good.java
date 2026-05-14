class Solution {
    public boolean isGood(int[] nums) {
        int[] isVisited = new int[201];
        
        int max = 0;
        int maxCount = 0;
        for(int num : nums){
            isVisited[num]++;
            if(max < num){
                max = num;
                maxCount=1;
            }else if(max == num){
                maxCount++;
            }
        }

        if(max+1 != nums.length)  return false;
        if(maxCount != 2)   return false;

        for(int i = 1; i < max; i++){
            if(isVisited[i] > 1)    return false;
        }
        return true;
    }
}