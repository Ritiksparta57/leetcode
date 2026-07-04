class Solution {
    public int reachNumber(int target) {
        int n=0;
        int sum=0;
        //if sum<target then surely we will not reach the no. yet;
        //if sum>target then we will see whether sum-target is even or not;
        //if not even then if we flip any right path n to negative(i.e. left) then it will never reach the target as th difference after flip is double of the no. i.e even;
        // target=7;
        // sum of all right paths=7*(7-1)/2=21;
        // the paths taken is +1,+2,+3,+4,+5,+6;
        //if we flip the last say  +6 to-6;then 15-6=9 which is 21-9=12 not 6 thus double of flip;
        //let us take +4 to -4 s=13 which is 21-13=8 double of flip;
        // thus if we want to make the target then for every flip we will have double of flip change to the sum;
        //thus the minimum no. of chances is the one where this sum-flip is even once it has crossed target;
        while(sum<Math.abs(target)||(sum-Math.abs(target))%2!=0){
            n++;
            sum+=n;
        }
        return n;
    }
}