class Solution {
    public int countBattleships(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] visit=new boolean[m][n];
        for(int i=0;i<m;i++)Arrays.fill(visit[i],false);
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              char ch=board[i][j];
              if(ch=='X'&&!visit[i][j]){
                dfs(i,j,dx,dy,visit,board,m,n);
                count++;
              }
            }
        }
        return count;
    }
    public void dfs(int i,int j,int[] dx,int[] dy,boolean[][] visit,char[][] board,int m,int n){
        visit[i][j]=true;
        for(int k=0;k<4;k++){
            int nx=i+dx[k];
            int ny=j+dy[k];
            if(nx>=0&&nx<m&&ny>=0&&ny<n&&board[nx][ny]=='X'&&!visit[nx][ny]){
                dfs(nx,ny,dx,dy,visit,board,m,n);
            }
        }
    }
}