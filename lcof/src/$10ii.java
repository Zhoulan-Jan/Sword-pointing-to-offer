/**
 * 青蛙跳台阶
 */
public class $10ii {
    public int numWays(int n) {
        if(n <= 0 ) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return n;
        }

        int first = 0;
        int second = 1;
        int third = 0;
        for (int i = 1; i <= n; i++) {
            third = (first + second) % 1000000007;
            first = second;
            second = third;
        }
        return third;
    }
}
