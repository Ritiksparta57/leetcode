class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        String sb=strs[0];
        for(int i=1;i<n;i++){
            String s=strs[i]; 
            String ans="";
            int j=0;
            int m=Math.min(sb.length(),s.length());
            while(j<m&&s.charAt(j)==sb.charAt(j)){
                ans+=s.charAt(j);
                j++;
            }
            sb=ans;
        }
        return sb;
    }
}