class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int r = grid.length, c = grid[0].length;
        
        Queue<Integer> rQ = new LinkedList<Integer>();
        Queue<Integer> cQ = new LinkedList<Integer>();
        Queue<Integer> lQ = new LinkedList<Integer>();
        if(grid[0][0]==0){
            rQ.add(0);
            cQ.add(0);
            lQ.add(1);
        }
        
        int[][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        
        Set<String> visited = new HashSet<String>();
        visited.add("0,0");
        while(!rQ.isEmpty() && !cQ.isEmpty()){
            int tr = rQ.poll(), tc = cQ.poll(), l = lQ.poll();
            if(tr==(r-1) && tc==(c-1)){
                return l;
            }
            
            for(int[] a: directions){
                if(isValidPoint(tr+a[0], tc+a[1], r, c, grid) && !visited.contains((tr+a[0])+","+(tc+a[1]))){
                    //System.out.println(tr + "," + tc);
                    visited.add((tr+a[0])+","+(tc+a[1]));
                    rQ.add(tr+a[0]);
                    cQ.add(tc+a[1]);
                    lQ.add(l+1);
                }
            }
        }
        return -1;
    }
    
    public boolean isValidPoint(int x, int y, int r, int c, int[][] grid){
        if(x>=0 && x<r && y>=0 && y<c && grid[x][y]==0){
            return true;
        }
        return false;
    }
}