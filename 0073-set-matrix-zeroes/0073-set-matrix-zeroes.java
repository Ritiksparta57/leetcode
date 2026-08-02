class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean firstr=false;//the first row contains 0 or not;
        boolean firstc=false;// the first column contains 0 or not;
        // check for first row;
        for(int j=0;j<n;j++){
            if(matrix[0][j]==0){
               firstr=true;
               break;
            }
        }
        //check for first column;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
               firstc=true;
               break;
            }
        }
        //now check for other rows and columns and mark the first row and column element for that element as 0;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;//matrix at that i and 0th column is 0 now
                    matrix[0][j]=0;// matrix at that j and 0th row is 0 now;
                    //this will help us to mark all elements in that ith row and ith column 0 if the flagged or starting one is 0;
                }
            }
        }
        // now mark all the elements as 0 for that row and col whose 0th row or 0th col is 0;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    //if 0th column of ith row is 0 or ith column of 0 th row is 0 then that line of element is 0 now;
                    matrix[i][j]=0;
                }
            }
        }
        // now if the first row or first col contains 0 then all of first row and first col will become 0 making everyone in that row or col 0;
        if(firstc){
            for(int i=0;i<m;i++)matrix[i][0]=0;
        }
        if(firstr){
            for(int i=0;i<n;i++)matrix[0][i]=0;
        }
    }
}