class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();
        int nums1Idx = 0;
        int nums2Idx = 0;
        int numIdx = 0;
        int[] nums = new int[nums1.length + nums2.length];

        while(numIdx < nums.length){
            int num1,num2;
            if(nums1Idx < nums1.length){
                num1 = nums1[nums1Idx];
            }else{
                num1 = Integer.MAX_VALUE;
            }
            if(nums2Idx < nums2.length){
                num2 = nums2[nums2Idx];
            }else{
                num2 = Integer.MAX_VALUE;
            }
            

            if(num1 < num2){
                nums[numIdx] = num1;
                nums1Idx++;
            }else if(num1 > num2){
                nums[numIdx] = num2;
                nums2Idx++;
            }else{
                nums[numIdx] = num1;
                numIdx++;
                nums1Idx++;
                nums[numIdx] = num2;
                nums2Idx++;
            }
            numIdx++;
        }

        if(nums.length%2 == 1)
            return nums[nums.length/2];
        return (float)(nums[nums.length/2] + nums[nums.length/2 - 1])/2;
    }
}