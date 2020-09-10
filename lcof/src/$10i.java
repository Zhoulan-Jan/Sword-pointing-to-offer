/**
 * 斐波那契数列
 * 考虑 n = 45的情况
 */
public class $10i {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib(n-1) + fib(n-2);
    }

    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        int third = 0;
        for (int i = 1; i < n; i++) {
            third = (first + second) % 1000000007; //考虑 n=45的情况
            first = second;
            second = third;
        }
        return third;
    }
}
