class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int pivot=findp(nums);
        if(pivot==-1)reverse(nums,0,n-1);
        else{
        int mingreatele=findmge(nums,pivot+1,n-1,nums[pivot]);
        swap(pivot,mingreatele,nums);
        reverse(nums,pivot+1,n-1);
        }
    }
    public int findp(int[] nums){
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1])return i;
        }
        return -1;
    }
    public int findmge(int[] nums,int s,int e,int comp){
        int min=s;
        for(int i=s+1;i<=e;i++){
            if(nums[i]>comp&&nums[i]<=nums[min]){
                min=i;
            }
        }
        return min;
    }
    public void swap(int pivot,int mge,int[] nums){
        int temp=nums[pivot];
        nums[pivot]=nums[mge];
        nums[mge]=temp;
    }
    public void reverse(int[] nums,int p,int n){
        while(p<=n){
            int temp=nums[p];
            nums[p]=nums[n];
            nums[n]=temp;
            p++;
            n--;
        }
    }
}