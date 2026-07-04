class Solution {
    public int addDigits(int num) {

        while(num>=10){
        int l=0;
        while(num>0){
            l+=num%10;
            num=num/10;
        }
        num=l;
        }
        return num;
    }
}