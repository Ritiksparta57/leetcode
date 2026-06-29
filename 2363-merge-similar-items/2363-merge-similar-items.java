class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int[] nums:items1){
           int value=nums[0];
           int weight=nums[1];
           if(!m.containsKey(value)){
            m.put(value,weight);
           }
           else{
             int w=m.get(value)+weight;
             m.put(value,w);
           }
        }
        for(int[] nums:items2){
            int value=nums[0];
           int weight=nums[1];
           if(!m.containsKey(value)){
            m.put(value,weight);
           }
           else{
             int w=m.get(value)+weight;
             m.put(value,w);
           }
        }
        List<List<Integer>> l=new ArrayList<>();
        for(Map.Entry<Integer,Integer> map:m.entrySet()){
            List<Integer> a=new ArrayList<>();
            int val=map.getKey();
            int we=map.getValue();
            a.add(val);
            a.add(we);
            l.add(a);
        }
        Collections.sort(l,(a,b)->a.get(0)-b.get(0));
        return l;
    }
}