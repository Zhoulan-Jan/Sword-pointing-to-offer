/**
 * 判断左上角的数字若大于 target ，则列 --，否则行 ++
 */
public class $4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0; //行数初始值，最大为 matrix.length - 1
        int col = matrix[0].length - 1; //列数初始值，最小为 0
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
