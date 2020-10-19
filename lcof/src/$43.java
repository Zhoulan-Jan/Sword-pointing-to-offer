/**
 * 1-n整数中1出现的次数
 * 法一：暴力解法，遍历每个数，得出每个数的1的个数，累加
 * 法二：公式法，问题分解为每个位置上1出现的个数，累加
 *      例：73562 cur为5，high为73，low为62；pow(10,i)为位因子，记为digit
 *      当cur == 0时，high*digit
 *      当cur == 1时，high*digit+low+1
 *      当cur > 1时，(high+1)*digit
 */
public class $43 {
    //公式法
    public int countDigitOne(int n) {
        int cur = n % 10;
        int high = n / 10;
        int low = 0;
        int digit = 1;
        int cnt = 0;

        while (high != 0 || cur != 0) {
            if (cur == 0) {
                cnt += high * digit;
            } else if (cur == 1) {
                cnt += high*digit+low+1;
            } else {
                cnt += (high+1) * digit;
            }

            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return cnt;
    }

    //法一
    public int countDigitOne2(int n) {
        int cnt = 0;
        for (int i = 0; i <= n; i++) {
            cnt += helper(i);
        }
        return cnt;
    }

    public int helper(int i) {
        int cnt = 0;
        while (i != 0) {
            if (i % 10 == 1) {
                cnt++;
            }
            i /= 10;
        }
        return cnt;
    }


}
