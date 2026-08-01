class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int freq=(int)Math.floor(n/3);
        List<Integer> l=new ArrayList<>();
        Map<Integer,Integer> m=new HashMap<>();
        for(int num:nums){
            m.put(num,m.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> m1:m.entrySet()){
            int val=m1.getValue();
            if(val>freq)l.add(m1.getKey());
        }
        return l;
    }
}