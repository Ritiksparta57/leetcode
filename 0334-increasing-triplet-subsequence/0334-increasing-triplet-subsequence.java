class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        List<Integer> l=new ArrayList<>();
        l.add(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>l.get(l.size()-1))l.add(nums[i]);
            else{
                int ind=bs(l,nums[i]);
                if(ind<0)ind=-(ind+1);
                l.set(ind,nums[i]);
            }
        }
        return l.size()>=3?true:false;
    }
    public int bs(List<Integer> l,int a){
        int s=0;
        int h=l.size()-1;
        int ans=-1;
        while(s<=h){
            int mid=(s+h)/2;
            if(l.get(mid)<a)s=mid+1;
            else{
                ans=mid;
                h=mid-1;
            }
        }
        return ans;
    }
}