class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n=intervals.length;
        List<int[]> l=new ArrayList<>();
        //create a previous array with the interval that is to be compared;
        int[] prev=intervals[0];
        for(int i=0;i<n;i++){
            int[] current=intervals[i];
            //if the prev[1] is less than current[0] then add prev to list;
            if(prev[1]<current[0]){l.add(prev);prev=current;}
            //else the interval need to be merged;
            // now the merging happens in a way such that min of both interval is at 0 and max is at 1 index;
            else{
                prev[0]=Math.min(prev[0],current[0]);
                prev[1]=Math.max(prev[1],current[1]);
            }
            // no need to do anything now since prev is updated when a interval is merged and not immediately added so that any other interval is to be merged then it can be done;
            // and when the prev[1]<curr[0] then the prev is added;
            //then the current becomes prev so as to merge the above well;
        }
        // the last element remins thus being merged here;
        l.add(prev);
        int[][] inter=new int[l.size()][2];
        int in=0;
        for(int[] go:l){
            inter[in]=go;
            in++;
        }
        return inter;
    }
}