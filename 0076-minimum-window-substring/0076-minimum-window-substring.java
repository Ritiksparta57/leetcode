class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m>n)return "";
        //now let us inintialize the hash table with the frequency of every character that is occuring in t;
        int[] hash=new int[256];
        for(int i=0;i<m;i++)hash[t.charAt(i)]++;
        //now let us initialize count,starti,minlen;
        int count=0;
        int starti=-1;
        int minlen=Integer.MAX_VALUE;
        int l=0;
        int h=l;
        while(h<n){
            char ch=s.charAt(h);
            //if we already have a character having hash value graeater than 0 then we have a character of t;
            if(hash[ch]>0)count++;
            //then we decrement hash value by one as we already have used one instance of it;
            hash[ch]--;
            //now the moment the value of count reaches m the length of t is the moment we will start decreasing the size of window;
            while(count==m){
                //we will calculate the minimum length and startindex;
                if(minlen>h-l+1){
                    minlen=h-l+1;
                    starti=l;
                }
                //then before decreasing the size we will add the frequuency one to hash of ch 
                //this is done in order to give back its one frequency;
                hash[s.charAt(l)]++;
                //now the moment we encounter any value of hash greater than 0 then we are removing a part of t thus making the count lose its one character;
                if(hash[s.charAt(l)]>0){
                    count--;
                }
                l++;
            }
            h++;
        }
        return minlen==Integer.MAX_VALUE?"":s.substring(starti,starti+minlen);
    }
}