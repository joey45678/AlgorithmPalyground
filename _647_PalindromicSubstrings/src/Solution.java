
public class Solution {
    public static int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
//            以一个元素为中心
            ans+=divide(s,s.length(),i,i);
        }
        for (int i = 0; i < s.length()-1; i++) {
//            以两个元素为中心
            ans+=divide(s,s.length(),i,i+1);
        }
        return ans;
    }
    //    中心扩散法
    public static int divide(String s,int len,int l,int r){
        int count = 0;
        while(l>=0 && r<=len-1 && s.charAt(l)==s.charAt(r)){
            l-=1;
            r+=1;
            count+=1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
