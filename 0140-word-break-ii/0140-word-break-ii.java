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