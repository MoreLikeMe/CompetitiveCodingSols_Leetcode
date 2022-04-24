class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<String> result = new HashSet<String>();
        for(int c=0;c<circles.length;c++){
            for(int i=(circles[c][0]-circles[c][2]);i<=circles[c][0]+circles[c][2];i++){
                for(int j=(circles[c][1]-circles[c][2]);j<=circles[c][1]+circles[c][2];j++){
                    if(((i-circles[c][0])*(i-circles[c][0])+(j-circles[c][1])*(j-circles[c][1]))<=(circles[c][2]*circles[c][2])){
                        result.add(i+","+j);
                        
                    }
                }
            }
        }
        return result.size();
    }
}