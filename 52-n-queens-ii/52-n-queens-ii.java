class Solution {
    public int totalNQueens(int n) {
        int[] rowcol = new int[n];
        Arrays.fill(rowcol, -1);
        return recurCall(n, 0, rowcol);
    }
    
    static int recurCall(int n, int row, int[] rowcol){
        
        //base case
        if(row==n){
            return 1;
        }
        
        //recursive call
        int count = 0;
        for(int i=0;i<n;i++){
            if(rowcol[row]==-1 && !isColOrDiagonalOccupied(rowcol, row, i+1)){
                rowcol[row] = i+1;
                count = count + recurCall(n, row+1, rowcol);
                rowcol[row] = -1;
            }
        }
        return count;
    }
    
    static boolean isColOrDiagonalOccupied(int[] rowcol, int row, int col){
        for(int i=0;i<rowcol.length;i++){
            if(rowcol[i]!=-1){
                if(col==rowcol[i] || Math.abs(i-row)==Math.abs(rowcol[i]-col)){
                    return true;
                }
            }
        }
        return false;
    }
}