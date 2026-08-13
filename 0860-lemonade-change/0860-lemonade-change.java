class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int five=0;
        int ten=0;
        int twen=0;
        for(int i=0;i<n;i++){
            if(bills[i]==5)five++;
            else if(bills[i]==10){
                ten++;
                if(five<1)return false;
                else five--;
            }
            else{
                twen++;
                if(five<3&&ten<1)return false;
                else if(five==0)return false;
                else{
                    if(five>=1&&ten>=1){
                        five--;
                        ten--;
                    }
                    else if(ten==0&&five>=3)five-=3;
                }
            }
        }
        return true;
    }
}