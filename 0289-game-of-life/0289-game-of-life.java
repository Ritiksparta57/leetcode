class Solution {
    public void gameOfLife(int[][] board) {
        int[] dx={1,1,1,-1,-1,-1,0,0};
        int[] dy={1,0,-1,-1,0,1,1,-1};
        int m=board.length;
        int n=board[0].length;
        //four cases->
        //1.if any 1 has less than two 1 then it dies;
        //2.if any 1 has 2 or 3  ones then it lives;
        //3.if any 1 has more than 3 ones then it dies;
        //4.if any 0 has exactly 3 ones then it lives;
        //5.else every other is dead then;
        boolean[][] lives=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    lives[i][j]=true;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=count(lives,m,n,dx,dy,i,j);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(lives[i][j]){
                    //case 2&3->
                   if(board[i][j]>=2&&board[i][j]<=3){
                    board[i][j]=1;
                   }
                   //case 1->
                   else board[i][j]=0;
                }
                else{
                    //case 4->
                    if(board[i][j]==3)board[i][j]=1;
                    //case 5->
                   else{
                    board[i][j]=0;
                    }
                }
            }
        }
    }
    public int count(boolean[][] lives,int m,int n,int[] dx,int[] dy,int x,int y){
        int c=0;
        for(int k=0;k<8;k++){
            int nx=x+dx[k];
            int ny=y+dy[k];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&lives[nx][ny])c++;
        }
        return c;
    }
}