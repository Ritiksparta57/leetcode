class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder s=new StringBuilder();
        long sum=0;
        while(n>0){
            int d=n%10;
            if(d!=0){
                sum+=(long)d;
                s.append(d);
            }
            n=n/10;
        }
        String sb=s.reverse().toString();
        if(sb.isEmpty())return 0;
        long a=Long.parseLong(sb);
        return a*sum;
    }
}