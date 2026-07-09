class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n=nums.size();
        if(sorted(nums))return 0;
        int i=0;
        while(i<n&&!sorted(nums)){
            rev(nums,0,n-1);
            rev(nums,1,n-1);
            i++;
        }
        if(i>=n)return -1;
        return i;
    }
    public boolean sorted(List<Integer> nums){
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)<nums.get(i-1))return false;
        }
        return true;
    }
    public void rev(List<Integer> nums,int s,int e){
        while(s<e){
            int temp=nums.get(s);
            nums.set(s,nums.get(e));
            nums.set(e,temp);
            s++;
            e--;
        }
    }
}