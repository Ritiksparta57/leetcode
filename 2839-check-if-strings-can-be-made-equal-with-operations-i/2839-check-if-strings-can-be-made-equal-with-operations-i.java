class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2))return true;
        StringBuilder sb=new StringBuilder(s1);
        StringBuilder sb1=new StringBuilder(s2);
        char a=s1.charAt(0);
        char b=s1.charAt(1);
        char d=s1.charAt(2);
        char e=s1.charAt(3);
        StringBuilder f=new StringBuilder(s1);
        f.setCharAt(0,d);
        f.setCharAt(2,a);
        if(f.toString().equals(s2))return true;
        StringBuilder g=new StringBuilder(s1);
        g.setCharAt(1,e);
        g.setCharAt(3,b);
        if(g.toString().equals(s2))return true;
        StringBuilder h=new StringBuilder(s1);
        h.setCharAt(1,e);
        h.setCharAt(3,b);
        h.setCharAt(0,d);
        h.setCharAt(2,a);
        if(h.toString().equals(s2))return true;
        return false;
    }
}