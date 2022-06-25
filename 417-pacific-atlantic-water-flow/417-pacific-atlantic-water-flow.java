class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantik = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            dfs(dir, i, 0, m ,n , pacific, heights);
            dfs(dir, i, n-1, m ,n , atlantik, heights);
        }
        for(int i=0;i<n;i++){
            dfs(dir, 0, i, m ,n , pacific, heights);
            dfs(dir, m-1, i, m ,n , atlantik, heights);
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] & atlantik[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        
        return res;
        
    }
    
    public void dfs(int[][] dir, int r, int c, int m, int n, boolean[][] isVisited, int[][] heights){
        
        isVisited[r][c] = true;
        for(int i=0;i<dir.length;i++){
            int tr = r + dir[i][0];
            int tc = c + dir[i][1];
            if(isValid(tr,tc,m,n) && !isVisited[tr][tc] && heights[tr][tc]>=heights[r][c]){
                dfs(dir, tr, tc, m, n, isVisited, heights);
            }
        }
    }
    
    public boolean isValid(int r, int c, int m, int n){
        if(r>=0 && r<m && c>=0 && c<n){
            return true;
        }
        return false;
    }
    
    
}