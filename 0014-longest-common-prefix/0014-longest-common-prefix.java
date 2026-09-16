class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = strs[0];

        for(int i = 1; i < strs.length; i++){
            int j = 0;

            while(j < answer.length() && j < strs[i].length()){
                if(answer.charAt(j) != strs[i].charAt(j)){
                    break;
                }
                j++;
            }
            answer = answer.substring(0, j);

            if(answer.length() == 0){
                return "";
            }
        }

        return answer;
    }
}