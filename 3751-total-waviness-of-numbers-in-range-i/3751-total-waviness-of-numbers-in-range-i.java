class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int index = num1; index <= num2; index++){
            int current = index;
            if(index < 100){
                continue;
            }
            int now = current%10;
            boolean peekState = false;
            boolean veleyState = false;
            while(current > 0){
                current /= 10;
                if(current == 0)
                    break;
                int prev = now;
                now = current % 10;
                
                if(prev < now){
                    veleyState = true;
                    if(peekState){
                        peekState = false;
                        count++;
                    }
                }else if(prev > now){
                    peekState = true;
                    if(veleyState){
                        veleyState = false;
                        count++;
                    }
                }else{
                    peekState =false;
                    veleyState = false;
                }
            }
        }
        return count;
    }
}