class Solution {
    public int maxProduct(int n) {
        // List<Integer> l=new ArrayList<>();
        // while(n>0){
        //     l.add(n%10);
        //     n=n/10;
        // }
        // Collections.sort(l);
        // return l.get(l.size()-1)*l.get(l.size()-2);
        //OR
        int max=0;
        int max1=0;
        while(n>0){
            int d=n%10;
            if(max<d){max1=max;max=d;}
            else if(d>max1){
                max1=d;
            }
            n=n/10;
        }
       return max*max1;
    }
}