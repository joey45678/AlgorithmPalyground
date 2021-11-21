import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
/*

 */
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuffer buffer = new StringBuffer();
        backtrack(digits,phoneMap,buffer,0,combinations);
        return combinations;
    }

    public static void backtrack(String numbers, Map<Character, String> phoneMap, StringBuffer combination, int index,List<String> ans) {
        if(index == numbers.length()){
            ans.add(combination.toString());
            return;
        }
        char number = numbers.charAt(index);
        String letters = phoneMap.get(number);

        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            backtrack(numbers,phoneMap,combination,index+1,ans);
            combination.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
