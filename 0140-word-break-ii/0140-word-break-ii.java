class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> st=new HashSet<>();
        for(String c:wordDict)st.add(c);
        List<String> l=new ArrayList<>();
        String sb="";
        dfs(0,n,s,st,sb,l);
        return l;
    }
    public void dfs(int i,int n,String s,Set<String> st,String sb,List<String> l){
        //whenever the i reaches n then only the strign is added  to l;
        //now when we check for dfs(j+1) and if there is no substring that belongs to set then i never reaches n thus the string never gets added to l;
        if(i==n){
            l.add(sb.trim());
            return;
        }
        String org=sb;//for backtracking purpose;
        //making of substring and checking its existence in set;
        for(int j=i;j<n;j++){
            String sub=s.substring(i,j+1);
            if(st.contains(sub)){
                sb+=sub+' ';
                dfs(j+1,n,s,st,sb,l);
                sb=org;
            }
        }
    }
}