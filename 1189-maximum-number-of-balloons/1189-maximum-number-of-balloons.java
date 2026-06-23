class Solution {
    public int maxNumberOfBalloons(String text) {
        int n=text.length();
        int[] count=new int[26];
        for(int i=0;i<n;i++){
            char ch=text.charAt(i);
            count[ch-'a']=count[ch-'a']+1;
        }
        int minoc=Integer.MAX_VALUE;
        int[] balloon=new int[5];
        balloon[0]=count[0];
        balloon[1]=count[1];
        balloon[2]=count[11]/2;
        balloon[3]=count[13];
        balloon[4]=count[14]/2;
        for(int i=0;i<5;i++){
            minoc=(int)Math.min(minoc,balloon[i]);
        }
        return minoc;
    }
}