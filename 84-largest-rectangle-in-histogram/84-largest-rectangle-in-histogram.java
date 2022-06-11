class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        
        //get the index of next smaller Element
        Stack<Integer> nextLesser = new Stack<>();
        int[] nextArr = new int[len];
        Arrays.fill(nextArr, -1);
        for(int i=0;i<len;i++){
            while(!nextLesser.isEmpty() && heights[i]<heights[nextLesser.peek()]){
                int t = nextLesser.pop();
                nextArr[t] = i;
            }
            nextLesser.push(i);
        }
        
        for(int i=0;i<len;i++){
            System.out.println(nextArr[i]);
        }
        
        System.out.println();
        
        //get the index of previous smaller Element
        Stack<Integer> prevLesser = new Stack<>();
        int[] prevArr = new int[len];
        Arrays.fill(prevArr, -1);
        for(int i=len-1;i>=0;i--){
            while(!prevLesser.isEmpty() && heights[i]<heights[prevLesser.peek()]){
                int t = prevLesser.pop();
                prevArr[t] = i;
            }
            prevLesser.push(i);
        }
        
        for(int i=0;i<len;i++){
            System.out.println(prevArr[i]);
        }
        
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