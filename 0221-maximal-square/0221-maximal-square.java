class Solution {
    public int maximalSquare(char[][] matrix) {
      int m=matrix.length;
      int n=matrix[0].length;
      //we are going to do top down approach;
      int max=0;
      int i=0;
      while(i<m){
        int j=0;
        while(j<n){
            //for sure we are only gonna take the matrix cell and calculate its area if the cell has a value of 1 else 0 will beocme 1 for the upcoming cells;
            if(matrix[i][j]=='1'){
                int val=matrix[i][j]-'0';
                //from here just go down,donright,down diagonal;
                int up=0;
                int diag=0;
                int left=0;
                if(i-1>=0){
                    up=matrix[i-1][j]-'0';
                }
                if(i-1>=0&&j-1>=0){
                    diag=matrix[i-1][j-1]-'0';
                }
                if(j-1>=0)left=matrix[i][j-1]-'0';
               int min=Math.min(up,Math.min(diag,left));
               max=Math.max(max,val+min);
               matrix[i][j]=(char)(min+val+'0');
            }
            j++;
        }
        i++;
      }
    return max*max;
    }
}