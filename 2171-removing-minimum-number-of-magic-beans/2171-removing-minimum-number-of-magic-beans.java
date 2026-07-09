class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long sum=0;
        for(int a:beans)sum+=a;
        //we cannot add any beans to make the no. equal to next one thus that no. will have to be 0;
        // therefore after every iteration the length of bean bag which are non empty will decrease by 1;
        //now for every iteration the non empty bags will be equal to a particular no. tahe will be the no. at i;
        //therefore the product of length of non empty bag and no. at i will give you the total sum that will be left after mking every non empty equal;
        // now we need to calculate the sum-prod difference and take the least difference as answer;
        // the reason is sum-prod gives the no. of bags removed from the whole system;
        // like in start there were sum amount of beans but after evry removal and equlaity the no. of beans that is removed is th difference;
        int m=beans.length;
        long res=Long.MAX_VALUE;
        for(int i=0;i<beans.length;i++){
            res=Math.min(res,sum-((long)beans[i]*m));
            // m=4;nums[i]=1;sum=16;
            // now the sum of array after everyone is 1 =>m*nums[i]=>1*4=4;
            //sum-prod=16-4=12 res=12(12 beans are to be removed);
            //m=3 as 0 is made0;nums[i]=4 ;sum=16;
            // m*nums[i]=3*4=12 and 16-12=4 res=4(4 to be removed);
            // m=2 and 1 is made 0;
            //5*2=10 res=6(6 to be removed ) but 4<6 therefore res=4;
            //and it goes on;
            m--;
        }
        return res;
    }
}