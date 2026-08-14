class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        //sort by end as we need to remove the minimum no. of intervals not maximum;
        //so if there is a bigger interval and within that interval multiple intervals which might not overlap are overlapping so we have to remove all those intervals rather than just 1;
        //therefore we sort by ends as it gives us the freedom to remove the biggest interval which can cause multiple overlaps;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        //here we just need to count not merge any interval;
        //thus for counting we need to sort the array and check if there are any overlapping interval or not;
        int[] prev=new int[2];
        int count=0;
        prev=intervals[0];
        for(int i=1;i<n;i++){
            int[] inter=intervals[i];
            if(inter[0]<prev[1]){
             count++;
            }
            else{
                prev=inter;
            }
        }
        return count;
    }
}