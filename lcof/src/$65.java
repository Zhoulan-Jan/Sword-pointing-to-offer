/**
 * 不用加减乘除做加法
 * 1.不考虑进位，相加 -> 异或
 * 2.记下进位 -> 位与，再往左移动一位
 * 3.两结果相加 -> 重复前两步，直到第二个加数为0
 */
public class $65 {
    public static int add(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        do {
            //不考虑进位，相加 -> 异或
            int sum = a ^ b;
            System.out.println("sum = " + sum);

            //记下进位 -> 位与，再往左移动一位
            int ci = (a & b) << 1;
            System.out.println("ci = " + ci);

            a = sum;
            b = ci;

            //两结果相加 -> 重复前两步，直到第二个加数为0
        } while (b != 0);


        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(15, 17));
        System.out.println(add(-5, 17));
    }

}
