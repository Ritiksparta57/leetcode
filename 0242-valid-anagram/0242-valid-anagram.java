class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m)return false;
        //easier approach is to make a count array and then add 1 to count of every character in the array;
        int[] count=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            count[ch-'a']++;
        }
        for(int i=0;i<m;i++){
            char ch=t.charAt(i);
            count[ch-'a']--;
        }
        //if any charaacter remains with value other than 0 then it is not an anagram as every character count must be 0 as both strings contains same amount of every character;
        for(int i=0;i<26;i++){
           if(count[i]!=0)return false;
        }
        // Map<Character,Integer> map=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     char ch=s.charAt(i);
        //     map.put(ch,map.getOrDefault(ch,0)+1);
        // }
        // for(int i=0;i<m;i++){
        //     char ch=t.charAt(i);
        //     if(!map.containsKey(ch))return false;
        //     map.put(ch,map.get(ch)-1);
        //     if(map.get(ch)==0){
        //         map.remove(ch);
        //     }
        // }

        return true;
    }
}