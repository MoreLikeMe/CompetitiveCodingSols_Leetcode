class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        int[][][] cache = new int[m][n][maxMove+1];
        for(int i=0;i<cache.length;i++){
            for(int j=0;j<cache[0].length;j++){
                Arrays.fill(cache[i][j],-1);
            }
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        return findAllPaths(startRow, startColumn, maxMove, m, n, dir, cache);
    }
    
    public int findAllPaths(int i, int j, int moveleft, int m, int n, int[][] dir, int[][][] cache){
        
        if(i<0 || j<0 || i>=m || j>=n){
            return 1;
        }
        
        if(moveleft==0){
            return 0;
        }
        
        if(cache[i][j][moveleft]!=-1){
            return cache[i][j][moveleft];
        }
       
        int res = 0;
        for(int k=0;k<dir.length;k++){
            int nr = i+dir[k][0], nc = j+dir[k][1];
            res = (res + findAllPaths(nr, nc, moveleft-1, m, n, dir, cache)%1000000007)%1000000007;
        }
        cache[i][j][moveleft] = res;
        return cache[i][j][moveleft];
    }
}