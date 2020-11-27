public class $13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];

        return movingCountHelper(m, n, 0, 0, k, visited);
    }

    public int movingCountHelper(int rows, int cols, int row, int col,
                                 int k, boolean[][] visited) {
        int cnt = 0;
        //System.out.println("world");
        if (check(rows, cols, row, col, k, visited)) {
            //System.out.println("hello");
            visited[row][col] = true;

            cnt = 1+movingCountHelper(rows, cols, row, col-1, k, visited)
                    + movingCountHelper(rows, cols, row-1, col, k, visited)
                    + movingCountHelper(rows, cols, row, col+1, k, visited)
                    + movingCountHelper(rows, cols, row+1, col, k, visited);
        }

        return cnt;
    }

    public boolean check(int rows, int cols, int row, int col,
                         int k, boolean[][] visited) {
        if (row < rows && row >= 0 && col < cols && col >= 0
            && getSum(row) + getSum(col) <= k
            && !visited[row][col]) {
            return true;
        }
        return false;
    }

    public int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        $13 a = new $13();
        //System.out.println(a.getSum(3537));

        System.out.println(a.movingCount(2,3,1));
        System.out.println(a.movingCount(3,1,0));
    }
}
