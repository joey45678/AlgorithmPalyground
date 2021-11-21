import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0) {
            return res;
        }
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int col = left; col <= right; ++col)
                res.add(matrix[up][col]);

            if (++up > down)
                break;


            for (int row = up; row <= down; ++row)
                res.add(matrix[row][right]);

            if (--right < left)
                break;

            for (int col = right; col >= left; --col)
                res.add(matrix[down][col]);

            if (--down < up)
                break;

            for (int row = down; row >= up; --row)
                res.add(matrix[row][left]);

            if (++left > right)
                break;

        }
        return res;
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        while (matrix.length >= 1) {
            for (int num : matrix[0]) {
                res.add(num);
            }
            matrix = reversalArr(matrix);
        }
        return res;
    }

    private int[][] reversalArr(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length - 1;
        int[][] reArr = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                reArr[i][j] = matrix[j + 1][m - i - 1];


        return reArr;
    }

    private static int[][] spiralArrayWith90(int arr[][]) {
        int rowLen = arr.length;
        int colLen = arr[0].length;
        int arr2[][] = new int[rowLen][colLen];

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr2[rowLen - j - 1][i] = arr[i][j];

        return arr2;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int arr2[][] = spiralArrayWith90(arr);
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}