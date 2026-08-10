class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(n>m)return "";
         int[] hash=new int[256];
         for(int i=0;i<n;i++)hash[t.charAt(i)]++;
         int minlen=Integer.MAX_VALUE;
         int count=0;
         int starti=-1;
         int l=0;
         int h=l;
         while(h<m){
            if(hash[s.charAt(h)]>0)count++;
            hash[s.charAt(h)]--;
            while(count==n){
               char ch=s.charAt(l);
               if(minlen>h-l+1){
                minlen=h-l+1;
                starti=l;
               }
               hash[ch]++;
               if(hash[ch]>0){
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