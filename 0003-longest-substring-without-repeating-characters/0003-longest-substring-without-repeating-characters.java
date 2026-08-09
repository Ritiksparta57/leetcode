class Solution {
    public int lengthOfLongestSubstring(String s) {
     int n=s.length();
     if(n==0)return 0;
     int l=0;
     int h=n-1;
     int i=l;
     int maxlen=1;
     Set<Character> st=new HashSet<>();
     while(i<=h){
        char ch=s.charAt(i);
        while(st.contains(ch)){
           char c=s.charAt(l);
           st.remove(c);
           l++;
        }
        maxlen=Math.max(maxlen,i-l+1);
        st.add(ch);
        i++;
     }
     return maxlen;
    }
}