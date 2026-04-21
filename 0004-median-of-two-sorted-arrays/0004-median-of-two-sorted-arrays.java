class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int nums1Idx = 0;
        int nums2Idx = 0;
        int numsLen = nums1.length + nums2.length;
        int numIdx = 0;
        int current = 0, prev = 0;

        while(numIdx <= numsLen/2){
            int num1,num2;
            prev = current;
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
                current = num1;
                nums1Idx++;
            }else{
                current = num2;
                nums2Idx++;
            }
            numIdx++;
        }

        if(numsLen%2 == 1)
            return current;
        return (float)(current + prev)/2;
    }
}