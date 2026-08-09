class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        Map<String,List<String>> m=new HashMap<>();
        for(int i=0;i<n;i++){
            String s=sort(strs[i]);
            if(!m.containsKey(s)){
               m.put(s,new ArrayList<>());
            }
            m.get(s).add(strs[i]);
        }
        List<List<String>> l=new ArrayList<>();
        for(Map.Entry<String,List<String>> m1:m.entrySet()){
            List<String> ans=m1.getValue();
            l.add(ans);
        }
        return l;
    }
    public String sort(String s){
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        String news=new String(ch);
        return news;     
    }
}