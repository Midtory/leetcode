class Solution {
    public int maxDistance(int[] colors) {
        int distance = 0;
        for(int index = 1; index < colors.length; index++){
            if(colors[0] != colors[index]){
                distance = index;
            }
        }

        for(int index = 0; index < colors.length-1; index++){
            if(colors[colors.length-1] != colors[index]){
                distance = Math.max(distance, colors.length - index - 1);
            }
        }
        return distance;
    }
}