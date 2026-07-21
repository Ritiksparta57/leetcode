class pair{
    long a;
    long b;
    public pair(long a1,long b1){
        this.a=a1;
        this.b=b1;
    }
}
class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        long max=Long.MIN_VALUE;
        long[] pre=new long[n];
        for(int i=0;i<n;i++){
            max=Math.max((long)nums[i],max);
            pre[i]=gcd((long)nums[i],max);
        }
        Arrays.sort(pre);
        Set<pair> s=new HashSet<>();
        long g=0;
        int i=0;
        int j=n-1;
        while(i<j){
            pair p=new pair(pre[i],pre[j]);
            if(!s.contains(p)){
                g+=gcd(pre[i],pre[j]);
            }
            i++;
            j--;
        }
        return g;
    }
    public long gcd(long a,long b){
        if(b==0)return a;
        else return gcd(b,a%b);
    }
}