class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] pre =new int[n];
        int[] suff =new int[n];
        int pro=1;
        for (int i=0;i<n;i++){
            pro*=nums[i];
            pre[i]=pro;
            if (pro==0)
                pro=1;
        }
        int suf=1;
        for (int i=n - 1;i>=0;i--) {
            suf*=nums[i];
            suff[i]=suf;
            if (suf==0)suf=1;
        }
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
            max=Math.max(max, Math.max(pre[i], suff[i]));
        }
        return max;
    }
}