class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // optimal is to store the no. with index in hashmap and take the complement that is how much more is needed to meet the sum or target and if any no. in map matches the complement then those are the two pairs;
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++){
            int complement=target-nums[i];//how much more is required to get target;
            if(m.containsKey(complement)){//if the requred no. is found in map then that is the list.
                return new int[]{m.get(complement),i};
            }
            m.put(nums[i],i);
        }
        return new int[]{};
    }
}