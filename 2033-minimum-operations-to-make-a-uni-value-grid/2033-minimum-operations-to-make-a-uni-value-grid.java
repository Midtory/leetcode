class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] array = new int[grid.length * grid[0].length];
        int arridx = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                array[arridx++] = grid[i][j];
            }
        }

        Arrays.sort(array);

        int mid = array[array.length/2];
        int mod = mid % x;  
        int count = 0;
        for(int current : array){
            if(current % x != mod){
                return -1;
            }

            count += Math.abs(current - mid) / x;
        }
        return count;
    }
}