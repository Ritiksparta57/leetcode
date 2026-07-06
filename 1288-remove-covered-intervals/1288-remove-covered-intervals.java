class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1])return a[0]-b[0];
            else return b[1]-a[1];
        });
        int count=0;
        int minimumseensofar=intervals[0][0];
        for(int i=1;i<n;i++){
            if(minimumseensofar<=intervals[i][0])count++;
            else minimumseensofar=intervals[i][0];
        }
        return n-count;
    }
}