class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int k1=k%(m*n);
        int size=m*n;
        int[] traverse=new int[m*n];
        int ind=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                traverse[ind++]=grid[i][j];
            }
        }
        rev(traverse,0,size-1);
        rev(traverse,0,k1-1);
        rev(traverse,k1,size-1);
        List<List<Integer>> l=new ArrayList<>();
        for(int i=0;i<m;i++){
            l.add(new ArrayList<>());
        }
        int ind1=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                l.get(i).add(traverse[ind1++]);
            }
        }
        return l;
    }
    public void rev(int[] a,int l,int h){
        while(l<h){
            int temp=a[l];
            a[l]=a[h];
            a[h]=temp;
            l++;
            h--;
        }
    }
}