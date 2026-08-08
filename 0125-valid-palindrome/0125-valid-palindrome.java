class Solution {
    public boolean isPalindrome(String s) {
        int n=s.length();
        // String s1="";
        // for(int i=0;i<n;i++){
        //     char ch=s.charAt(i);
        //     if(Character.isLetterOrDigit(ch)){
        //         s1+=Character.toLowerCase(ch);
        //     }
        // }
        // n=s1.length();
        // int i=0;
        // int j=n-1;
        // while(i<=j){
        //     char ch=s1.charAt(i);
        //     char c=s1.charAt(j);
        //     if(ch!=c){
        //       return false;
        //     }
        //     i++;
        //     j--;
        // }
        // let us try the optimal one->
        int i=0;
        int j=n-1;
        while(i<=j){
            //we will increment i or j (decrement) when we encounter a non-alphanumeric character;
            //first for i and then j;
            while(i<j&&!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j&&!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            //now let us convert the character to lowercase and then compare
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))return false;
            i++;
            j--;
        }
        return true;
    }
}