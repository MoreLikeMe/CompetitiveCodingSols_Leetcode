class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] remaining  = new int[capacity.length];
        for(int i=0;i<capacity.length;i++){
            remaining[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(remaining);
        
        int ind = 0, count=0;
        while(ind<remaining.length && additionalRocks>0){
                if(additionalRocks>=remaining[ind]){
                    additionalRocks -= remaining[ind];
                    remaining[ind] = 0;
                    count++;
                } else {
                    remaining[ind] = additionalRocks;
                    additionalRocks = 0;
                }
            ind++;
        }
        return count;
    }
}