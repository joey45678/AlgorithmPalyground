
class Solution {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
//        fill the first row cell for dp.
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
//        fill the first column cell for dp.
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
//        fill other cells for dp.
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp[i].length; i1++) {
                System.out.print(dp[i][i1]+" ");
            }
            System.out.println();
        }

        return dp[rows - 1][columns - 1];
    }

    public static void main(String[] args) {
        int array[][] = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        /*

            1 4 5
            2 7 6
            6 8 7

         */
        minPathSum(array);
    }
}