class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int count=0;
        String ans="";
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch>='0'&&ch<='9'){
               ans+=ch;
               count++;
            }
            else{
                if(count==0){
                    if(ch==' ')continue;
                    else if(ch=='-'||ch=='+'){
                        if(ans.length()==0){ans+=ch;count++;}
                        else break;
                    }
                    else break;
                }
                else{
                  break;
                }
            }
        }
        if(ans.length()==0||ans.equals('-')||ans.equals('+'))return 0;
        int i=0;
        String ans1="";
        if(ans.charAt(i)=='-'){i=1;ans1+='-';}
        else if(ans.charAt(i)=='+'){i=1;ans1+='+';}
        while(i<ans.length()&&ans.charAt(i)=='0'){
            i++;
        }
        if(i==ans.length())return 0;
        while(i<ans.length()){ans1+=ans.charAt(i);i++;}
        //now manually convert ans to digit;
        long answer=0;
        int j=0;
         int sign=1;
        if(ans1.charAt(0)=='-'){sign=-1;j=1;}
        if(ans1.charAt(0)=='+')j=1;
        while(j<ans1.length()){
            int digit=ans1.charAt(j)-'0';
            answer=answer*10+digit;
            if(sign==1&&answer>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(sign==-1&&-answer<Integer.MIN_VALUE)return Integer.MIN_VALUE;
            j++;
        }
        return (int)(sign*answer);
    }
}