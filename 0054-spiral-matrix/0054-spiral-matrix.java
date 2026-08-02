class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> l=new ArrayList<>();
        int top=0;
        int bottom=m-1;
        int left=0;
        int right=n-1;
        //for the topmost;
        while(top<=bottom&&left<=right){
        int i=left;
        while(i<=right){
             l.add(matrix[top][i]);
             i++;
        }
        top++;//we have figured out first row
        //for last column;
        int j=top;
        while(j<=bottom){
            l.add(matrix[j][right]);
            j++;
        }
        right--;//we have figured out last column
        // now for last row;
       if(top<=bottom){
          for(int k=right;k>=left;k--)l.add(matrix[bottom][k]);
          bottom--;
       }
       //first column
       if(left<=right){
        for(int k=bottom;k>=top;k--)l.add(matrix[k][left]);
        left++;
       }
        }
        return l;
    }
}