class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] rowcol = new int[n];
        Arrays.fill(rowcol, -1);
        
        return recurCall(n, 0, rowcol, new ArrayList<List<String>>());
    }
    
    static List<List<String>> recurCall(int n, int row, int[] rowcol, List<List<String>> result){
        
        //base case
        if(row==n){
            List<String> temp = new ArrayList<String>();
            for(int j=0;j<n;j++){
                String t = "";
                for(int i=0;i<n;i++){
                    if(rowcol[j]-1!=i){
                        t = t + ".";
                    } else {
                        t = t + "Q";
                    }
                }
                temp.add(t);
            }
            result.add(temp);
            return result;
        }
        
        //recursive call
        for(int i=0;i<n;i++){
            if(rowcol[row]==-1 && !isColOrDiagonalOccupied(rowcol, row, i+1)){
                rowcol[row] = i+1;
                recurCall(n, row+1, rowcol, result);
                rowcol[row] = -1;
            }
        }
        return result;
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