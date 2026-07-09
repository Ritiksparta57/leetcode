class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n=nums.length;
        List<Integer> l=new ArrayList<>();
        for(int a:nums)l.add(a);
        if(sorted(l))return 0;
        int count=0;
        while(!sorted(l)){
            int i=0;
            int minsum=l.get(i)+l.get(i+1);
            for(int j=1;j<l.size()-1;j++){
                int sum=l.get(j)+l.get(j+1);
                if(sum<minsum){
                    minsum=sum;
                    i=j;
                }
            }
             l.set(i,minsum);
             l.remove(i+1);
            count++;
        }
        return count;
    }
    public boolean sorted(List<Integer> nums){
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)<nums.get(i-1))return false;
        }
        return true;
    }
}