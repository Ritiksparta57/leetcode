class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int prod=1;
        int nfsap=n;
        while(nfsap>0){
            int digit=nfsap%10;
            sum+=digit;
            prod=prod*digit;
            nfsap=nfsap/10;
        }
        int finalsum=sum+prod;
        return n%finalsum==0?true:false;
    }
}