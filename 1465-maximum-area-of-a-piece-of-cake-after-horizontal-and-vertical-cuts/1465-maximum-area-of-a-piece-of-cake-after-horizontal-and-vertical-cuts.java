class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int hMax = getMaxDiff(horizontalCuts, h);
        int wMax = getMaxDiff(verticalCuts, w);
        
        return (int)(((long)hMax*wMax)%1000000007);
        
    }
    
    public int getMaxDiff(int[] arr, int n){
        int max = -1;
        for(int i=0;i<=arr.length;i++){
            if(i==0){
                max = arr[0];
            }
            else if(i==arr.length){
                max = Math.max(max, n-arr[i-1]);
            }
            else{
                max = Math.max(max, arr[i]-arr[i-1]);
            }
        }
        return max;
    }
}