class Solution {
    public int minDistance(String word1, String word2) {
        //see we do not need to do anything with matching characters;
        //also when we replace the character we just increment or decrement the index as per our choice from both strings same as we do in matching ones as after replacing we get the same character;
        //all we have to think is about insert and delete operations;
        //we need to convert word1 to word2;
        //if we delete a character then i moves to other one that is i+1 and j remains where it is;
        //but we insert a character i remains where it is and j moves further;
        //example=> w1=exection w2=execution 
        //Insertion-> when i is on c and j is on c then after j goes to j+1=u and i to i+1=t
        //since replacement will not do the job as length will remain less than w2 therefore insertion is the option thus we assume that u is inserted before t where i+1 is there but j+1is on u in w2; Thus after insertion we still are on t where i+1 was there and j is on t where j+2 should be there;
        //example=> w1=execution w2=exection;
        //Deletion-> when i+1 is on u then j+1 is on t but since replacement would not do the job as w2<w1 thus we need to remove i+1 so we move i+1 to i+2 as such i+1 was never there but it had no effect on j+1 as it is on t itself;
        //THUS FINAL CALL-> MATCH->I+1,J+1;
        //REPLACE->I+1,J+1;
        //INSERTION->I,J+1;
        //DELETION->I+1,J;
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return dfs(0,0,m,n,dp,word1,word2);
    }
    public int dfs(int i,int j,int m,int n,int[][] dp,String s,String t){
        //base cases can be if we reach the end of word2 and still word1 is not completed then we need to remove that many characters from word1;
        //and second is if we reach the end of word1 but word2 is still there then we will have to insert that many characters in word1;
        if(j>=n){
            return (m-i);
        }
        if(i>=m){
            return (n-j);
        }
        if(dp[i][j]!=-1)return dp[i][j];
        //now the major part->
        int l=0;
        char ch=s.charAt(i);
        char c=t.charAt(j);
        int insert=0;
        int delete=0;
        int replace=0;
        if(ch==c)l=dfs(i+1,j+1,m,n,dp,s,t);//no operations carried out;
        //we cnnot use directly the l as we may add up insert,replace and delete all together;thus using seperate variables for all these actions as we can compare which one is less;
        else{
            //here the three operations will be done;
            //replace->
            replace=1+dfs(i+1,j+1,m,n,dp,s,t);
            //insertion->i already at the pos where j+1 should be in w2;
            insert=1+dfs(i,j+1,m,n,dp,s,t);
            //deletion->j is at the pos where i+1 will be there in w1;
            delete=1+dfs(i+1,j,m,n,dp,s,t);
            //as keeping l out of here may alter the value by not taking the matching things;
           l=Math.min(insert,Math.min(delete,replace));
        }
        return dp[i][j]=l;
    }
}