class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        // String sb=strs[0];
        // for(int i=1;i<n;i++){
        //     String s=strs[i]; 
        //     String ans="";
        //     int j=0;
        //     int m=Math.min(sb.length(),s.length());
        //     while(j<m&&s.charAt(j)==sb.charAt(j)){
        //         ans+=s.charAt(j);
        //         j++;
        //     }
        //     sb=ans;
        // }
        Arrays.sort(strs);
        //we know that first and last might have the maximum same character that can be found after sorting;
        String first=strs[0];
        String last=strs[n-1];
        int min=Math.min(first.length(),last.length());
        int i=0;
        String ans="";
        while(i<min&&first.charAt(i)==last.charAt(i)){
             ans+=first.charAt(i);
             i++;
        }
        return ans;
    }
}