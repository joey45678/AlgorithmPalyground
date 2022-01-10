public class Solution {
    public static int rob(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }
        int[] result = new int[array.length];

        result[0] = array[0];
        result[1] = Math.max(array[0], array[1]);


        for (int i = 2; i < array.length; i++) {
            result[i] = Math.max(array[i] + result[i - 2], result[i - 1]);
        }


        return result[result.length - 1];
    }

    public static int rob2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }

        int first = array[0];
        int second = Math.max(array[0], array[1]);


        for (int i = 2; i < array.length; i++) {
            int temp = second;
            second = Math.max(first + array[i], second);
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }
}
