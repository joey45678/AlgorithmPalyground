import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {

        if(n <= 0){
            return res;
        }
        generateParenthesis("",n,n);
        return res;
    }
    public static void generateParenthesis(String parenthesis,int left,int right){
        if(left==0 && right ==0){
            res.add(parenthesis);
            return;
        }

        if(left==right){
            generateParenthesis(parenthesis+"(",left-1,right);
        }else if(left<right){
            if(left>0){
                generateParenthesis(parenthesis+"(",left-1,right);
            }
            generateParenthesis(parenthesis+")",left,right-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
