class Solution {
    public long[] distance(int[] nums) {
        
        long[] answer = new long[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int index = 0;
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(index);
            index++;
        }
        
        for (List<Integer> values : map.values()) {
            int size = values.size();
            
            long sum = 0;
            for (int i = 0; i < size; i++) {
                int idx = values.get(i);
                answer[idx] += (long) idx * i - sum;
                sum += idx;
            }
            
            sum = 0;
            for (int i = size - 1; i >= 0; i--) {
                int idx = values.get(i);
                answer[idx] += sum - (long) idx * (size - 1 - i);
                sum += idx;
            }
        }
        return answer;
    }
}