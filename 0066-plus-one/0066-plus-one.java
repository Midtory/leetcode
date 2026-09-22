class Solution {

    public int[] plusOne(int[] digits) {

        boolean value = true;

        int[] result = new int[digits.length];

        for(int i = digits.length - 1; i >= 0; i--){
            if(value){
                result[i] = (digits[i] + 1) % 10;
                if((digits[i] + 1) < 10){
                    value = false;
                }
            }
            else{
                result[i] = digits[i];
            }
        }
        if(value){
            int[] newResult = new int[digits.length + 1];
            newResult[0] = 1;
            for(int i = 1; i < newResult.length; i++){
                newResult[i] = 0;
            }

            return newResult;
        }
        return result;
    }
}