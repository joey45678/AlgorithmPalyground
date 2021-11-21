
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0)
            return;

//        统计非零元素
        int x = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0)
                nums[x++] = nums[i];

        for (int k = x; k < nums.length; k++)
            nums[k] = 0;

        int a = 1;
    }

    public static void moveZeroes2(int[] nums) {
//        right指向非零元素，left指向0元素
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,0,3,0};
        moveZeroes2(arr);

        for (int i : arr) {
            System.out.print(i+" ");
        }

    }

}
