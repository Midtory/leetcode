class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> answer = new ArrayList<>();
        int size = queries.length;
        int length = queries[0].length();
        for(String query : queries){
            for(String word : dictionary){
                int count = 0;
                for(int index = 0; index < length; index++){
                    if(query.charAt(index) != word.charAt(index)){
                        count++;
                    }
                    if(count > 2){
                        break;
                    }
                }
                if(count <= 2){
                    answer.add(query);
                    break;
                }
            }
        }

        return answer;
    }
}