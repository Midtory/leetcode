class Solution {
    public int smallestRepunitDivByK(int k) {
        

        int n = 1;
        for(int length = 1; length <= k; length++){
            n = (n % k) * 10 + 1;
            if(n == 1)
                return length;
        }
        return -1;

    }
}