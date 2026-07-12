class Solution {
    public int[] arrayRankTransform(int[] arr){
        int n=arr.length;
        if(n==0)return new int[]{};
        int[] cop=Arrays.copyOf(arr,n);
        Arrays.sort(cop);
        Map<Integer,Integer> m=new HashMap<>();
        int rank=1;
        m.put(cop[0],1);
        for(int i=1;i<n;i++){
            if(m.containsKey(cop[i])){
                continue;
            }
            rank++;
            m.put(cop[i],rank);
        }
        int[] ranka=new int[n];
        for(int i=0;i<n;i++){
            ranka[i]=m.get(arr[i]);
        }
        return ranka;
    }
}