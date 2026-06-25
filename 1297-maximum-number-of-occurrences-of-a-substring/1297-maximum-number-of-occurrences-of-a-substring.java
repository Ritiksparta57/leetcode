class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n=s.length();
        Map<Character,Integer> m=new HashMap<>();
        Map<String,Integer> map=new HashMap<>();
        int left=0;
        int i=0;
        while(i<n){
            char ch=s.charAt(i);
            //u should always add first the element and then remove the elements one by one using while loop until m.size()<=maxletter;
            m.put(ch,m.getOrDefault(ch,0)+1);
            //we need to check whether the letters as less than maxletters in a given window.
            //here maxsize is a distraction we just need to maintain a window of minsize and there itself we need to count;
            if(i-left+1>minSize){
                char c=s.charAt(left);
                m.put(c,m.get(c)-1);
                if(m.get(c)==0)m.remove(c);
                left++;
            }
            if(i-left+1==minSize&&m.size()<=maxLetters){
                String help=s.substring(left,i+1);
                map.put(help,map.getOrDefault(help,0)+1);
            }
            i++;
        }
        int v=0;
        for(Map.Entry<String,Integer> m1:map.entrySet()){
           v=(int)Math.max(v,m1.getValue());
        }
        return v;
    }

}