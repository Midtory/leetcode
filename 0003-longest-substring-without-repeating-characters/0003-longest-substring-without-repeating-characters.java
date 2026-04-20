class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] alp = new boolean[26];
        int max = 0;

        int left = 0; 
        int right = 1;
        if (s.length() == 0) return 0;
        
        alp[s.charAt(left) - 'a'] = true;
        while(right < s.length()){
            int toInt = s.charAt(right) - 'a';
            //같은 문자 있음
            if(alp[toInt]){
                max = Math.max(max, right - left);
                for(int index = left; index < right; index++){
                    int current = s.charAt(index) - 'a';
                    if(current == toInt){
                        left = index + 1;
                        alp[current] = false;
                        break;
                    }
                    alp[current] = false;
                }
            }else{
                alp[toInt] = true;
                right++;
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}