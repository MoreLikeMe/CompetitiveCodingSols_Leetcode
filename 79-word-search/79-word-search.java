class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        char[][] modBoard = new char[m+2][n+2];
        boolean[][] isVisited = new boolean[m+2][n+2];
        for(int i=0;i<m+2;i++){
            for(int j=0;j<n+2;j++){
                if(i==0 || j==0 || i==m+1 || j==n+1){
                    modBoard[i][j] = '-';
                } else {
                    modBoard[i][j] = board[i-1][j-1];
                }
            }
        }
        
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(!isVisited[i][j] && modBoard[i][j]!='-' && word.charAt(0)==modBoard[i][j]){
                    //call the recursive function to check
                    if(isMatching(isVisited, modBoard, 0, i, j, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isMatching(boolean[][] isVisited, char[][] board, int index, int i, int j, String word){
        
        if(word.length()-1==index){
            return true;
        }
        
        isVisited[i][j] = true;
        index++;
        boolean isMatching = false;
        if(board[i+1][j]!='-' && !isVisited[i+1][j] && board[i+1][j]==word.charAt(index)){
            isMatching = isMatching | (isMatching(isVisited, board, index, i+1, j, word));
        }
        if(board[i-1][j]!='-' && !isVisited[i-1][j] && board[i-1][j]==word.charAt(index)){
            isMatching = isMatching | (isMatching(isVisited, board, index, i-1, j, word));
        }
        if(board[i][j+1]!='-' && !isVisited[i][j+1] && board[i][j+1]==word.charAt(index)){
            isMatching = isMatching | (isMatching(isVisited, board, index, i, j+1, word));
        }
        if(board[i][j-1]!='-' && !isVisited[i][j-1] && board[i][j-1]==word.charAt(index)){
            isMatching = isMatching | (isMatching(isVisited, board, index, i, j-1, word));
        }
        
        isVisited[i][j] = false;
        
        return isMatching;
    }
}