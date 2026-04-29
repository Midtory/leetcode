class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int result = 0;
        for(int index = 0; index < s.length(); index++){
            char current = s.charAt(index);

            if(current == 'a'){
                result = Math.min(result + 1, countB);
            }else{
                countB++;
            }
        }

        return result;
    }
}