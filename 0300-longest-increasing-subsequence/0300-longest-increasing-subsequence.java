class Solution {
    public int lengthOfLIS(int[] nums) {
        //see all we have to do is we need to create a list and keep adding the numbers in that list until we find a number that is smaller than the last number in the list;
        //then we find the index of the upcoming smaller no in the list where it will be located and then the element at that index is removed and new one is inserted;
        //thus giving the longest list;
        //all this to be done using binary search;
        int n=nums.length;
        List<Integer> l=new ArrayList<>();
        l.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>l.get(l.size()-1)){
                l.add(nums[i]);
            }
            else{
                int ind=bs(nums[i],l);
                if(ind<0)ind=ind+1;
                l.set(ind,nums[i]);
            }
        }
        return l.size();
    }
    public int bs(int num,List<Integer> l){
        int h=l.size()-1;
        int low=0;
        int ans=-1;
        while(low<=h){
            int mid=(low+h)/2;
            if(l.get(mid)<num)low=mid+1;
            else{
               ans=mid;
               h=mid-1;
            }
        }
        return ans;
    }
}