import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenxin
 * @create 2021-10-20 9:00
 */

//给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//        此外，你可以假设该网格的四条边均被水包围。
//
//
//
//        示例 1：
//
//        输入：grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//        输出：1
//        示例 2：
//
//        输入：grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//        输出：3
//
//
//        提示：
//
//        m == grid.length
//        n == grid[i].length
//        1 <= m, n <= 300
//        grid[i][j] 的值为 '0' 或 '1'


public class test_200 {
    public static void main(String[] args) {

    }
}

class Solution52 {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
//                    dfs(grid, i, j);
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    //深度优先遍历
//    public void dfs(char[][] grid, int i, int j) {
//        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
//            return;
//        }
//        grid[i][j] = '0';
//        dfs(grid, i + 1, j);
//        dfs(grid, i, j + 1);
//        dfs(grid, i - 1, j);
//        dfs(grid, i, j - 1);
//    }

    //广度优先遍历
    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> list = new LinkedList<>();
        list.add(new int[]{i, j});
        while (!list.isEmpty()) {
            int[] cur = list.poll();
            i = cur[0];
            j = cur[1];
            if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                list.add(new int[]{i + 1, j});
                list.add(new int[]{i - 1, j});
                list.add(new int[]{i, j + 1});
                list.add(new int[]{i, j - 1});
            }
        }
    }
}