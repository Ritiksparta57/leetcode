class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String l=Integer.toString(low);
        String h=Integer.toString(high);
        int sl=l.length();
        int sh=h.length();
        List<Integer> ans=new ArrayList<>();
        String s="123456789";
        for(int i=sl;i<=sh;i++){
            for(int j=0;j+i<=9;j++){
              String sb=s.substring(j,j+i);
              int num=Integer.parseInt(sb);
              if(num>=low&&num<=high)ans.add(num);
            }
        }
        
        return ans;
    }
}