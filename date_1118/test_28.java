/**
 * @author chenxin
 * @create 2021-11-18 14:39
 */

//48. 旋转图像
//        给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
//        你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//
//
//        示例 1：
//
//
//        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        输出：[[7,4,1],[8,5,2],[9,6,3]]
//        示例 2：
//
//
//        输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//        输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//        示例 3：
//
//        输入：matrix = [[1]]
//        输出：[[1]]
//        示例 4：
//
//        输入：matrix = [[1,2],[3,4]]
//        输出：[[3,1],[4,2]]

public class test_28 {
    public static void main(String[] args) {

    }
}

class Solution92 {
    public void rotate(int[][] matrix) {
        rot(matrix, 0, matrix.length);
    }

    private void rot(int[][] mat, int level, int rank) {
        if (rank > 1) {
            for (int i = 0; i < rank - 1; i++) {
                int temp = mat[level][level + i];
                mat[level][level + i] = mat[level + rank - i - 1][level];
                mat[level + rank - i - 1][level] = mat[level + rank - 1][level + rank - 1 - i];
                mat[level + rank - 1][level + rank - 1 - i] = mat[level + i][level + rank - 1];
                mat[level + i][level + rank - 1] = temp;
            }
            rot(mat, level + 1, rank - 2);
        }

    }
}
