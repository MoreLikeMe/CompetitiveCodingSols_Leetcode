class Solution {
    public int trap(int[] height) {
        
        int ind = 0, len = height.length, tMax=0, tMin=0, tMinInd=0, sum=0;
        while(ind<len){
            int tInd = ind+1;
            boolean flag = false;
            tMax = height[ind];
            tMin = Integer.MIN_VALUE;
            tMinInd = -1;
            
            while(tInd<len && height[tInd]<tMax){
                if(tMin<height[tInd]){
                    tMin = height[tInd];
                    tMinInd = tInd;
                }
                tInd++;
                flag = true;
            }
            
            if(flag){
                if(tInd<len){
                    sum += getTrappedAmount(height, ind, tInd, true); 
                    ind = tInd;
                    continue;
                }
                else {
                    sum += getTrappedAmount(height, ind, tMinInd, false);
                    ind = tMinInd;
                    continue;
                }
            }
            
            ind++;
            
        }
        
        return sum;
        
    }
    
    public int getTrappedAmount(int[] height, int start, int end, boolean straight){
        int sum=0, ind=0;
        if(straight){
            ind = start;
        } else{
            ind = end;
        }
        for(int i=start+1;i<end;i++){
            sum += height[ind]-height[i];
        }
        return sum;
    }
}