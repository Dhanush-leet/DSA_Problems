class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        
        List<String> result = new ArrayList<>();

        for(int hour=0;hour<12;hour++){
            for(int min=0;min<60;min++){

                if(countBits(hour)+ countBits(min)==turnedOn){
                    result.add(String.format("%d:%02d", hour, min));
                }
            }
        }
        return result;
    }

    private int countBits(int n){
        int count =0;
        while(n!=0){
            n= n&(n-1);
            count++;
        }
        return count;
    }
}