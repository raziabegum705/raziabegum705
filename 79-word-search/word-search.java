class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
public boolean dfs(char[][] board,String word,int i,int j, int index){
    int n=board.length;
        int m=board[0].length;
        
    if(index==word.length()){
        return true;
    }
    if(i<0||j<0||j>=m||i>=n||word.charAt(index)!=board[i][j]||board[i][j]=='*'){
        return false;
    }
    char temp=board[i][j];
   board[i][j]='*';
    boolean found=dfs(board,word,i+1,j,index+1)||dfs(board,word,i,j-1,index+1)||dfs(board,word,i-1,j,index+1)||dfs(board,word,i,j+1,index+1);
    board[i][j]=temp;
    return found;
}
}