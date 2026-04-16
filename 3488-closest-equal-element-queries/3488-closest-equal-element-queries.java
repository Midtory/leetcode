class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap <Integer, List<Integer>> hashmap = new HashMap<>();
        for(int index = 0; index < nums.length; index++){
            int current = nums[index];
            if(hashmap.containsKey(current)){
                hashmap.get(current).add(index);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(index);
                hashmap.put(current, list);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for(int index = 0; index < queries.length; index++){
            int query = queries[index];
            if(hashmap.get(nums[query]).size() == 1){
                answer.add(-1);
            }
            else{
                List<Integer> list = hashmap.get(nums[query]);
                int current = Collections.binarySearch(list, query);
                int min = Integer.MAX_VALUE;
                if(current > 0){
                    int left = list.get(current - 1);
                    int leftDist = Math.abs(query - left);
                    min = Math.min(min, Math.min(leftDist, nums.length - leftDist));
                }if(current < list.size()-1){
                    int right = list.get(current + 1);
                    int rightDist = Math.abs(query - right);
                    min = Math.min(min, Math.min(rightDist, nums.length - rightDist));
                }
                int left = list.get(0);
                int leftDist = Math.abs(query - left);
                min = Math.min(min, nums.length - leftDist);

                int right = list.get(list.size() - 1);
                int rightDist = Math.abs(query - right);
                min = Math.min(min, nums.length - rightDist);

                answer.add(min);
            }
        }
        return answer;
    }
}