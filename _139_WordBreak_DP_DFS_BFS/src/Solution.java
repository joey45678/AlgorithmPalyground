
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static boolean DwordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() + 1];
        return dfs(s, 0, wordDict, visited);
    }

    private static boolean dfs(String s, int start, List<String> wordDict, boolean[] visited) {
        for (String word : wordDict) {
            int nextStart = start + word.length();
            boolean nextStartOverflow = nextStart > s.length();
            if (nextStartOverflow || visited[nextStart])
                continue;

            int wordStart = s.indexOf(word, start);
            if (wordStart == start) {
                boolean goDepth = dfs(s, nextStart, wordDict, visited);
//                  代表完整地扫描到末尾
                if (nextStart == s.length() || goDepth)
                    return true;
                visited[nextStart] = true;
            }
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                boolean c1 = wordDictSet.contains(s.substring(j, i));
                boolean c2 = dp[j];
                if (c2 && c1) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {

        List<String> objects = new ArrayList<>();
        objects.add("leet");
        objects.add("code");
        System.out.println(DwordBreak("leetcode", objects));
    }
}
