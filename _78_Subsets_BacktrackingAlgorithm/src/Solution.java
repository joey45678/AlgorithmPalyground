
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, 0, nums.length, path, res);
        return res;
    }

    private static void dfs(int[] nums, int begin, int end, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < end; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1, end, path, res);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> listList = subsets(new int[]{1, 2,3});
        System.out.println(listList);
    }


}
