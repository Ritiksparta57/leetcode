class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        int max=0;
        while(left<=right){
            boolean l=prime(nums[left]);
            boolean r=prime(nums[right]);
            if(l&&r){
              int dist=Math.abs(right-left);
              max=Math.max(max,dist);
              break;
            }
            else if(l&&!r)right--;
            else if(!l&&r)left++;
            else{
                left++;
                right--;
            }
        }
        return max;
    }
    public boolean prime(int n){
        if(n<=1)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}