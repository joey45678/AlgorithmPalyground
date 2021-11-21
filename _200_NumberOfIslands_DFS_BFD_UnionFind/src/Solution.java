
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid)     {
        int num = 0;

        if (grid.length == 0)
            return 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    deepSearch(grid, r, c);
                    num++;
                }
            }
        }
        return num;
    }
    private static void deepSearch(char[][] graph, int r, int c) {
        if (r < 0 || c < 0 || r > graph.length - 1 || c > graph[r].length - 1)
            return;

        if (graph[r][c] == '0')
            return;

        if (graph[r][c] == '1')
            graph[r][c] = '0';

        deepSearch(graph, r - 1, c);
        deepSearch(graph, r + 1, c);
        deepSearch(graph, r, c - 1);
        deepSearch(graph, r, c + 1);

    }

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }



}