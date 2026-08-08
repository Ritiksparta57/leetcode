class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        String s1="";
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                s1+=Character.toLowerCase(ch);
            }
        }
        n=s1.length();
        int i=0;
        int j=n-1;
        while(i<=j){
            char ch=s1.charAt(i);
            char c=s1.charAt(j);
            if(ch!=c){
              return false;
            }
            i++;
            j--;
        }
        return true;
    }
}