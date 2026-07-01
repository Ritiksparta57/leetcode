class Solution {
    public int largestPrime(int n) {
        List<Integer> l=new ArrayList<>();
        boolean[] isprime=new boolean[n+1];
        Arrays.fill(isprime,true);
        isprime[0]=false;
        isprime[1]=false;
        prime(n,isprime);
        for(int i=0;i<=n;i++){
            if(isprime[i]){
                l.add(i);
            }
        }
        int min=0;
        int sum=0;
        int i=0;
        List<Integer> add=new ArrayList<>();
        while(sum<=n&&i<l.size()){
          sum+=l.get(i++);
          if(sum<=n){
            add.add(sum);
          }
        }
        for(int j=add.size()-1;j>=0;j--){
            if(isprime[add.get(j)]){
                return add.get(j);
            }
        }
        return 0;
    }
    public void prime(int n,boolean[] isprime){
        for(int i=2;i*i<=n;i++){
           if(isprime[i]){
            for(int j=i*i;j<=n;j+=i){
                isprime[j]=false;
            }
           }
        }
    }
}