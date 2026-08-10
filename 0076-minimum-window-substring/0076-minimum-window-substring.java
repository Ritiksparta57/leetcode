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
  //BRUTE OR OPTIMIZED BRUTE-------------------------------------------------->
        // // what we are going to do is take a hash table with 256 size (covering all characters in english alphabet) then for every character in s from 0 to n-1 we will store t's character in hash table and then iterate over s in inner loop from j=i to n-1 ant then check if there has been a case where hash[s[j]]>0 then we increment a count pointer that says how many character of t we have visited already;
        // //then set hash[s[j]]--;
        // //then if count becomes equal to length of t then we have found all the characters of t;
        // //then now we will take the minimum length of string and set the first index of substring to j and make a substring from i to i+minlength;
        // int minlen=Integer.MAX_VALUE;
        // int starti=0;
        // //we will start the search from every index
        // for(int i=0;i<m;i++){
        //     //now set hash for the begining of every search
        //     int[] hash=new int[256];
        //     int count=0;//how many characters of t are found in the current window of s;
        //     //now let us set hash value for characters in t
        //     for(int j=0;j<n;j++){
        //         hash[t.charAt(j)]++;
        //     }
        //     //now take the inner loop from i to n-1 for making substring and checking whether t occurs in between them or not;
        //     for(int j=i;j<m;j++){
        //         if(hash[s.charAt(j)]>0)count++;//if already computed as in t then +ve value thus we found one character of t;
        //         hash[s.charAt(j)]--;
        //         if(count==n){
        //         if(minlen>j-i+1){
        //             minlen=j-i+1;
        //             starti=i;
        //         }
        //         break;
        //         }
        //     }
        //     }