class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col-1;
        while(validIndex(i,j,row,col)){
            if(matrix[i][j]==target){
                return true;
            }
            else if(matrix[i][j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        
        return false;
    }
    
    public boolean validIndex(int i, int j, int row, int col){
        if(i>=0 && j>=0 && i<row && j<col){
            return true;
        }
        return false;
    }
}