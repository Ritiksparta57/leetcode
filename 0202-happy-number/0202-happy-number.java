class Solution {
    public boolean isHappy(int n) {
      Set<Integer> s=new HashSet<>();
      while(n!=1){
       if(s.contains(n))return false;
       s.add(n);
      int sum=0;
      while(n>0){
        int temp=n%10;
        sum+=temp*temp;
        n=n/10;
      }  
      n=sum;
    }
    return true;
}
}