class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //상하 반전
        for(int index = 0; index < n/2; index++){
            int[] arr = matrix[index];
            matrix[index] = matrix[n - 1 - index];
            matrix[n - 1 - index] = arr;
        }
        //대각선 변환
        for(int row = 0; row < n; row++){
            for(int col = 0; col < row; col++){
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}