class Solution {
    public boolean isHappy(int n) {
        if(n==1)return true;
        Set<Integer> st=new HashSet();
        while(n>0){
            if(st.contains(n))return false;
            st.add(n);
            int sum=0;
            while(n>0){
                int d=n%10;
                sum+=Math.pow(d,2);
                n=n/10;
            }
            if(sum==1)return true;
            else n=sum;
        }
        return false;
    }
}