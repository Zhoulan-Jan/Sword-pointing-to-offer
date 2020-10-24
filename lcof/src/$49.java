/**
 * 丑数
 */
public class $49 {
    public static int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int cnt = 1;

        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        while (cnt < n) {
            int min = min(uglyNums[multiply2]*2, uglyNums[multiply3]*3, uglyNums[multiply5]*5);
            uglyNums[cnt] = min;

            while (uglyNums[multiply2]*2 <= uglyNums[cnt]) {
                multiply2++;
            }

            while (uglyNums[multiply3]*3 <= uglyNums[cnt]) {
                multiply3++;
            }

            while (uglyNums[multiply5]*5 <= uglyNums[cnt]) {
                multiply5++;
            }

            cnt++;
        }

        int ugly = uglyNums[cnt - 1];
        return ugly;
    }

    public static int min(int a, int b, int c) {
        int min = a < b ? a : b;

        min = min < c ? min : c;

        return min;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
    
    //暴力法
    public int nthUglyNumber2(int n) {
        int i = 1;
        int cnt = 0;

        while (true) {
            if (isUgly(i)) {
                cnt++;
                if (cnt == n) {
                    break;
                }
            }
            i++;
        }
        return i;
    }

    public boolean isUgly(int i) {
        while (i % 2 == 0) {
            i /= 2;
        }
        while (i % 3 == 0) {
            i /= 3;
        }
        while (i % 5 == 0) {
            i /= 5;
        }

        return i == 1;
    }
}
