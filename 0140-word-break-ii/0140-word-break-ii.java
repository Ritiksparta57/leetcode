class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //we need to reconstruct afterr making the dp array or we do backtracking;
        //it is asking for giving it all the combinations therefore i am gonna use backtracking;
        int n=s.length();
        List<String> l=new ArrayList<>();
        Set<String> st=new HashSet<>();
        String sb="";
        for(String s1:wordDict)st.add(s1);
        dfs(0,n,s,st,sb,l);
        return l;
    }
    public void dfs(int i,int n,String s,Set<String> st,String sb,List<String> l){
        //base case is whne we reach n;
        //see what happens is when i recurse after seeing that the substring is in the set then we are moving i to j+1 but if the string has a part which is not in set then at that point i will not move forward and will never go to bc i==n thus the string will never get added to list as the base case in fulfilled;
        //in word break 1 also when we were checking if substring belongs to stet also the next substring from j+1 should also belong and if above problem occurs then j never reaches bc thus again returning false at the end;
        if(i==n){
            l.add(sb.trim());
            return;
        }
        if(i>n)return;
        //here we add the substrings to the string sb;
        for(int j=i;j<n;j++){
            String org=sb;
            String sub=s.substring(i,j+1);
            if(st.contains(sub)){
                sb+=sub+' ';
                dfs(j+1,n,s,st,sb,l);//running for next one taking sb as string;
                sb=org;
            }
        }
    }
}