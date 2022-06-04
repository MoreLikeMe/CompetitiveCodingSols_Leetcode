class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)-> {return (a[0]-b[0]);});
        List<int[]> result = new ArrayList<int[]>();
        
        int index = 1;
        int start = intervals[0][0], end = intervals[0][1];
        while(index<intervals.length){
            
            while(index<intervals.length && intervals[index][0]>=start && intervals[index][0]<=end){
                if(intervals[index][1]>end){
                    end = intervals[index][1];
                }
                index++;
            }
            result.add(new int[]{start, end});
            if(index<intervals.length){
                start = intervals[index][0];
                end = intervals[index][1];
            } else {
                start =-1;
                end = -1;
            }
            index++;
        }
        if(!(start==-1 && end==-1)){
            result.add(new int[]{intervals[intervals.length-1][0], intervals[intervals.length-1][1]});
        }
        
        int[][] resultArr = new int[result.size()][];
        result.toArray(resultArr);
        return resultArr;
        
    }
}