class Solution {
    public void solveSudoku(char[][] board) {
        recurCall(board, 0, 0);
    }
    
    public boolean recurCall(char[][] board, int r, int c){
        if(r==9 && c==0){
            //print the board
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            return true;
        }
        
        boolean res = false;
        int nextRow = (c==8)?(r+1):r;
        int nextCol = (c==8)?0:(c+1);
        if(board[r][c]!='.'){
            res = recurCall(board, nextRow, nextCol);
        } else{
            for(int i=49;i<=57;i++){
                if(isValid(board, r, c, i)){
                    board[r][c] = (char)i;
                    res = recurCall(board, nextRow, nextCol);
                    if(res)
                        break;
                    board[r][c] = '.';
                }
            }
        }
        return res;
    }
    
    public boolean isValid(char[][] board, int r, int c, int ch){
        
        //check the row
        for(int i=0;i<9;i++){
            if(board[r][i]==ch){
                return false;
            }
        }
        
        //check the col
        for(int i=0;i<9;i++){
            if(board[i][c]==ch){
                return false;
            }
        }
        
        //check sub grid
        int rStart = -1, cStart = -1;
        if(r>5 && r<9){
            rStart = 6;
        } else if(r>2){
            rStart = 3;
        } else if(r>=0){
            rStart = 0;
        }
        
        if(c>5 && c<9){
            cStart = 6;
        } else if(c>2){
            cStart = 3;
        } else if(c>=0){
            cStart = 0;
        }
        
        for(int i=rStart;i<rStart+3;i++){
            for(int j=cStart;j<cStart+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
    
}