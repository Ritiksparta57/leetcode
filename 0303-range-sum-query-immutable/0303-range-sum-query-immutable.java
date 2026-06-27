class NumArray {
    // List<Integer> a=new ArrayList<>();
    private int[] prefix;
    public NumArray(int[] nums) {
       int n=nums.length;
       prefix=new int[n+1];
       for(int i=0;i<n;i++){
        prefix[i+1]=prefix[i]+nums[i];
       }
    //    for(int i=0;i<n;i++)a.add(nums[i]);
    }
    
    public int sumRange(int left, int right) {
        // int sum=0;
        // while(left<=right){
        //    sum+=a.get(left);
        //    left++;
        // }
        // return sum;
        return  prefix[right+1]-prefix[left];//range me end-1 hota hai;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */