class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        
        //get the index of next smaller Element
        Stack<Integer> stack = new Stack<>();
        int[] nextArr = new int[len];
        Arrays.fill(nextArr, -1);
        for(int i=0;i<len;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int t = stack.pop();
                nextArr[t] = i;
            }
            stack.push(i);
        }
        
        //get the index of previous smaller Element
        stack = new Stack<>();
        int[] prevArr = new int[len];
        Arrays.fill(prevArr, -1);
        for(int i=len-1;i>=0;i--){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int t = stack.pop();
                prevArr[t] = i;
            }
            stack.push(i);
        }
        
        stack = null;
        
        //Iterate over the nextArr and prevArr to calculate
        //the maximum area covered
        int max = Integer.MIN_VALUE;
        for(int i=0;i<len;i++){
            int start = prevArr[i]!=-1?prevArr[i]:-1;
            int end = nextArr[i]!=-1?nextArr[i]:len;
            if(max<((end-start-1)*heights[i])){
                max = (end-start-1)*heights[i];
            }
        }
        
        return max;
    }
}