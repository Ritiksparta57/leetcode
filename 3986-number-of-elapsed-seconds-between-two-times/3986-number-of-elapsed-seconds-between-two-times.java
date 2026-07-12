class Solution {
    public int secondsBetweenTimes(String s, String e) {
        int sh=Integer.parseInt(s.substring(0,2))*3600;
        int sm=Integer.parseInt(s.substring(3,5))*60;
        int ss=Integer.parseInt(s.substring(6,8));
        int start=sh+sm+ss;
        int eh=Integer.parseInt(e.substring(0,2))*3600;
        int em=Integer.parseInt(e.substring(3,5))*60;
        int es=Integer.parseInt(e.substring(6,8));
        int end=eh+em+es;
        return end-start;
    }
}