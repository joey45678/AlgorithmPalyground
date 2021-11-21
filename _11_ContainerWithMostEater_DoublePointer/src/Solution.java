
public class Solution {

    public static int maxArea(int[] height) {
        int max = 0;
        if (height == null || height.length == 0)
            return max;

        int left = 0,right = height.length - 1;

        while (left < right) {
            max = Math.max((Math.min(height[left], height[right]) * (right - left)), max);
            if (height[left] > height[right]) right--; else left++;
        }
        return max;
    }


    public static int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int watter = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, watter);
            if (height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));

    }
}

