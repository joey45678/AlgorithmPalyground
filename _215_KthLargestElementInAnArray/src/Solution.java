public class Solution {
    public static void quickSort(int l,int r,int[] array){
        if(l>=r)
            return;
        int left = l;
        int right = r;
        int divider = array[left];
        while (left<right){
            while (left<right && array[right] <= divider)
                right--;
            array[left] = array[right];

            while (left<right && array[left] >= divider)
                left++;
            array[right] = array[left];
        }
        array[left] = divider;
        quickSort(l,left-1,array);
        quickSort(right+1,r,array);
    }
    public static int findKthLargest(int[] nums, int k) {
        quickSort(0,nums.length-1,nums);

        return nums[k-1];
    }



    public static void main(String[] args) {
        int[] array = new int[]{3,2,3,1,2,4,5,5,6};
//        quickSort(0,array.length-1,array);
//        for (int num : array) {
//            System.out.print(num);
//        }
        System.out.println(findKthLargest(array,4));

    }
}
