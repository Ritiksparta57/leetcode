class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int[] num:nums1){
            int val=num[0];
            int we=num[1];
            m.put(val,m.getOrDefault(val,0)+we);
        }
        for(int[] num:nums2){
            int val=num[0];
            int we=num[1];
            m.put(val,m.getOrDefault(val,0)+we);
        }
        int s=m.size();
        int[][] res=new int[s][2];
        int ind=0;
        for(Map.Entry<Integer,Integer> map:m.entrySet()){
            int val=map.getKey();
            int we=map.getValue();
            res[ind][0]=val;
            res[ind][1]=we;
            ind++;
        }
       Arrays.sort(res,(a,b)->a[0]-b[0]);
       return res;
    }
}