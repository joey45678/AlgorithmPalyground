
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 0)
            return new int[]{};

        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            dfs(temperatures, temperatures[i], i + 1, 0, i, res);
        }
        return res;
    }

    public static void dfs(int[] temperatures, int temperature, int idx, int count, int currentIdx, int[] res) {

        if (idx >= temperatures.length) {
            count = 0;
            res[currentIdx] = count;
            return;
        }
        if (temperature < temperatures[idx]) {
            count++;
            res[currentIdx] = count;
            return;
        }
        if (temperature >= temperatures[idx]) {
            count++;
            dfs(temperatures, temperature, idx + 1, count, currentIdx, res);
        }
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = length - 1; i >= 0; --i) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int t = temperatures[i] + 1; t <= 100; ++t) {
                if (next[t] < warmerIndex) {
                    warmerIndex = next[t];
                }
            }
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            next[temperatures[i]] = i;
        }
        return ans;
    }

    public static int[] dailyTemperatures3(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
//            在当前温度大于之前的温度时，计算结果
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
//    暴力法
    public static int[] dailyTemperatures4(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++)
            for (int j = i + 1; j < temperatures.length; j++)
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = dailyTemperatures3(new int[]{30, 30, 40});
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }
}
