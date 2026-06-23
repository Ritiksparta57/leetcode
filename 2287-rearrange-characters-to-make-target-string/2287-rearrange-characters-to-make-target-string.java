class Solution {
    public int rearrangeCharacters(String s, String target) {
        int n=s.length();
        int l=target.length();
        int[] count=new int[26];
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            count[ch-'a']=count[ch-'a']+1;
        }
        int minoc=Integer.MAX_VALUE;
        for(int i=0;i<l;i++){
            m.put(target.charAt(i),m.getOrDefault(target.charAt(i),0)+1);
        }
        for(Map.Entry<Character,Integer> m1:m.entrySet()){
            int v=m1.getValue();
            int k=m1.getKey();
            count[k-'a']=count[k-'a']/v;
            minoc=(int)Math.min(minoc,count[k-'a']);
        }
        return minoc;
    }
}