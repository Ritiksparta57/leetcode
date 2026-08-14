class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int startcol=image[sr][sc];
        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};
        boolean[][] vis=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{sr,sc});
        vis[sr][sc]=true;
        image[sr][sc]=color;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int[] coor=q.poll();
                int x=coor[0];
                int y=coor[1];
                for(int k=0;k<4;k++){
                    int nx=x+dx[k];
                    int ny=y+dy[k];
                    if(nx>=0&&ny>=0&&nx<m&&ny<n&&vis[nx][ny]==false&&image[nx][ny]==startcol){
                       image[nx][ny]=color;
                       vis[nx][ny]=true;
                       q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        return image;
    }
}