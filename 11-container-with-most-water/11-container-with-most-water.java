class Solution {
    public int maxArea(int[] height) {
        
        int i=0,j=height.length-1,max=Integer.MIN_VALUE;
        while(i<j){
            int temp = 0;
            if(height[i]>height[j]){
                temp = height[j]*(j-i);
                j--;
            } else {
                temp = height[i]*(j-i);
                i++;
            }
            if(temp>max){
                max=temp;
            }
        }
        return max;
    }
}