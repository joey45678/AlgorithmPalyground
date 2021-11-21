
import java.util.Collections;
import java.util.LinkedList;

public class Solution {

    static int ptr;

    public static String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            // 获取一个数字并进栈
            if (Character.isDigit(cur)) {
                String digits = getDigits(s);
                stk.addLast(digits);
                // 获取一个字母或者左括号并进栈
            } else if (Character.isLetter(cur) || cur == '[') {
                stk.addLast(String.valueOf(s.charAt(ptr++)));
//                遇到右括号，出站
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    //    持续地获取数字
    public static String getDigits(String s) {
        StringBuffer ret = new StringBuffer();

        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public static String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        System.out.println(decodeString("2[a2[bc]]"));
    }
}
