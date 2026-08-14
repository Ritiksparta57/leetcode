class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> l=new ArrayList<>();
        l.add(points[0]);
        for(int i=1;i<n;i++){
            int[] inter=points[i];
            while(l.size()-1>=0&&inter[0]<=l.get(l.size()-1)[1]){
                int[] listinter=l.get(l.size()-1);
                l.remove(l.size()-1);
               int max=Math.max(inter[0],listinter[0]);
               int min=Math.min(inter[1],listinter[1]);
               inter=new int[]{max,min};
            }
            l.add(inter);
        }
        return l.size();
    }
}