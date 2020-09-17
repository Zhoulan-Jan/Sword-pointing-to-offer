/**
 * 顺时针打印矩阵
 * 1.考虑行或列 <= 0，返回 new int[0]
 * 2.一圈的判断：一圈的最后一个数字满足：start * 2 < rows && start * 2 < columns
 * 3.打印一圈 终止行 endX 终止列 endY
 *      i）从左到右打印 总会进行
 *      ii）从上到下打印 endX > start
 *      iii）从右到左打印 endX > start && endY > start
 *      iV）从下到上打印 endX - start >= 2 && endY > start
 * 4.start++，循环打印多圈
 */

import java.util.Arrays;

public class $29 {
    public int[] spiralOrder(int[][] matrix) {

        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int start = 0;
        int[] res = new int[rows * columns];
        int cnt = 0;
        while (start * 2 < rows && start * 2 < columns) {
            int endY = columns - start - 1;
            int endX = rows - start - 1;
            //从左往右打印
            for (int i = start; i <= endY; i++) {
                res[cnt++] = matrix[start][i];
            }

            //从上到下打印
            if (endX > start) {
                for (int i = start+1; i <= endX; i++) {
                    res[cnt++] = matrix[i][endY];
                }
            }

            //从右往左打印
            if (endX > start && endY > start) {
                for (int i = endY-1; i >= start; i--) {
                    res[cnt++] = matrix[endX][i];
                }
            }

            //从下往上打印
            if (endX - start >= 2 && endY > start) {
                for (int i = endX - 1; i >= start+1; i--) {
                    res[cnt++] = matrix[i][start];
                }
            }
            start++;
        }

        return res;
    }

//    public static void main(String[] args) {
//        String[] str = {"0"};
//        String str2[] = {"0", "0", "0"}; //编译运行通过，但会提示数组定义格式错误
////        String str3[8] = {"0"}; //错误语句
////        String[] str4 = new String[8]{"0"}; //错误语句
//        String[] str5 = new String[]{"0","0","0"}; //输出 0
//        String[] str6 = new String[8]; //输出 null
//        System.out.println(Arrays.toString(str6));
//    }

    public static void main(String[] args) {
        $29 x= new $29();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(x.spiralOrder(matrix)));
    }
}
