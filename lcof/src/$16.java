/**
 * 数的整数次方
 * 基数可能为0（浮点数判断相等靠近似相等）
 * 指数可能为负数（转化为整数，再将值取倒数）
 * 指数的取值为 [−2^31, 2^31 − 1]，需要将 int -> long
 * 尽量少地使用递归
 */
public class $16 {
    public static double myPow(double x, int n) {
        if (x - 0.0 < 0.000001 && x - 0.0 > -0.000001) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        long exp = n;
        if (exp < 0) {
            return 1/pow2(x, -exp);
        }

        return pow2(x, exp);
    }

    //时间复杂度过高
    public static double pow(double x, long n) {
        double res = 1;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }

    public static double pow2(double x, long n) {
        double res = 1;
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }

        res = pow2(x, n >> 1);
        res *= res;
        if (n % 2 == 1) {
            res *= x;
        }
        return res;

        //这种写法，运行了很多次的递归，会超出时间限制
//        if (n % 2 == 1) {
//            return pow2(x, n >> 1) * pow2(x, n >> 1) * x;
//        } else {
//            return pow2(x, n >> 1) * pow2(x, n >> 1);
//        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000 ,10) + " 1024");
        System.out.println(myPow(2.0000, -10) + " 0.00098");

        //int n = 16;
        //System.out.println( n >>= 1); //8
        //System.out.println(n >> 1);
    }
}
