class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        //tc->o(n);
        //sc->o(n);
        //approach hashmap->
        // int comp=n/2;
        // int max=nums[0];
        // Map<Integer,Integer> m=new HashMap<>();
        // for(int i=0;i<n;i++)m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        // for(Map.Entry<Integer,Integer> m1:m.entrySet()){
        //     int val=m1.getValue();
        //     if(val>comp){
        //         max=m1.getKey();
        //     }
        // }
        // return max;
        //tc->o(n);
        //sc->o(1);
        //algo name-> BOYRE MOORE VOTING ALGO;
        int count=0;
        int cand=0;
        for(int i=0;i<n;i++){
            if(count==0){
               cand=nums[i];
               count++;
            }
            else if(cand==nums[i])count++;
            else{
                count--;
            }
        }
        return cand;
    }
}