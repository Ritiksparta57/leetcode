class Solution {
    public void wiggleSort(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int mid=(n-1)/2;
        List<Integer> l1=new ArrayList<>();
        for(int i=mid;i>=0;i--){
            l1.add(nums[i]);
        }
        List<Integer> l2=new ArrayList<>();
        for(int i=n-1;i>mid;i--){
            l2.add(nums[i]);
        }
        int i=0;
        int j=0;
        int l=0;
        while(l<n){
            if(l%2==0){
                nums[l]=l1.get(i);
                i++;
            }
            else{ nums[l]=l2.get(j);j++;}
            l++;
        }
    }
}