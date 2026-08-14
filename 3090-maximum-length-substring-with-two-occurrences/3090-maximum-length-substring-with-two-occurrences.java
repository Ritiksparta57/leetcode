class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int l=0;
        int h=n-1;
        int i=l;
        Map<Character,Integer> m=new HashMap<>();
        int maxlen=0;
        while(i<=h){
           char ch=s.charAt(i);
           m.put(ch,m.getOrDefault(ch,0)+1);
           while(m.get(ch)>2){
              m.put(s.charAt(l),m.get(s.charAt(l))-1);
              if(m.get(s.charAt(l))==0)m.remove(s.charAt(l));
              l++;
           }
           int len=i-l+1;
           maxlen=Math.max(len,maxlen);
           i++;
        }
        return maxlen;
    }
}