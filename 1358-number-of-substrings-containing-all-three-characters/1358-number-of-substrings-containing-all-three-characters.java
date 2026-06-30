class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int left=0;
        int count=0;
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            m.put(ch,m.getOrDefault(ch,0)+1);
            while(m.size()==3){
              count+=(n-i);//not i-left cause once the string with 3 characters is found then the upcoming strings will surely be part of substrings with 3 characters; so this gives us the exact count of no. of substrings;
              m.put(s.charAt(left),m.get(s.charAt(left))-1);
              if(m.get(s.charAt(left))==0)m.remove(s.charAt(left));
              left++;
            }
        }
        return count;
    }
}