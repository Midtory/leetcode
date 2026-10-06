class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int x = a.length() - 1;
        int y = b.length() - 1;
        int carry = 0;

        while(x >= 0 || y >= 0 || carry > 0) {
            int sum = carry;

            if(x >= 0) {
                sum += a.charAt(x) - '0';
                x--;
            }
            if(y >= 0) {
                sum += b.charAt(y) - '0';
                y--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }
}

