class Solution {
    public int minimumEffort(int[][] tasks) {
        
        //규칙 정렬
        Arrays.sort(tasks, (a, b) -> {
        return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int total = 0;
        int current = 0;

        for(int[] task : tasks){
            int spendEnergy = task[0];
            int minimumEnergy = task[1];

            if(current < minimumEnergy){
                total += (minimumEnergy - current);
                current = minimumEnergy;
            }

            current -= spendEnergy;

        }
        return total;
    }
}