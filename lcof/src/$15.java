/**
 * 二进制中1的个数
 * 法一：数字每右移一位 & 1 == 1 ? 1的个数增加
 * 法二：flag每左移一位 & n == 1 ? 1的个数增加
 * 法三：(n-1)&n 在n != 0 的情况下，计算的次数。
 *      因为整数-1，把最右边的1变成0，若右边仍有0，则变为1，
 *      比如 1011-1=1010 ，1100-1=1011
 */
public class $15 {
    //法三
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = (n-1) & n;
        }
        return cnt;//为什么不能做位运算
    }

    //法一
//    public int hammingWeight2(int n) {
//        int cnt = 0;
//        while (n != 0) {
//            if (n & 1 == 1) {
//                cnt++;
//            }
//            n = n >> 1;
//        }
//        return cnt;
//    }

    //法二
//    public int hammingWeight3(int n) {
//        int cnt = 0;
//        int flag = 1;
//        while (flag <= n) {
//            if (flag & n == 1) {
//                cnt++;
//            }
//            flag = flag << 1;
//        }
//        return cnt;
//    }

}
