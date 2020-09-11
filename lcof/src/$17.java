import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 * char = int +'0'
 * 法一：直接找到最大的n位数，遍历打印
 * 法二：每个数用字符数组打印，
 *      1.当字符数组+1产生溢出，表示数组表示的数字是最大的n位数 （O(1)）
 *      （也可用 数组上的每一个数字是否为9判断，但是复杂度为O(n)）
 *      2.将字符数组转为数字进行保存
 * 法三：递归
 *      设n=2 charNum[0] = 0~9
 *      charNum[0] = 0, charNum[1] = 0~9
 *      charNum[0] = 1, charNum[1] = 0~9
 *      …… charNum[0] = 9, charNum[1] = 0~9
 */

public class $17 {
    //当最大的数仍为int型
    public int[] printNumbers(int n) {
        if (n <= 0) {
            return null;
        }

        int max = 0;

        while (n != 0) {
            max = max * 10 + 9;
            n--;
        }

        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i-1] = i;
        }
        return res;
    }

    //考虑大数 -> 字符串表示
    public int[] printNumbers2(int n) {
        if (n <= 0) {
            return null;
        }

        int len = n;
        int max = 0;
        while (n != 0) {
            max = max * 10 + 9;
            n--;
        }

        int[] res = new int[max];
        int cnt = 0;

        //将某个数用字符数组保存
        char[] charNum = new char[len];

        //一定要有初始化
        for (int i = 0; i < charNum.length; i++) {
            charNum[i] = '0';
        }

        //判断num是否为最大的n位数
        while (!increment(charNum)) {
            //（打印数字）数字保存到数组中
            res[cnt++] = saveNumber(charNum);
        }
        return res;
    }

    public boolean increment(char[] num) {
        boolean isOverflow = false;
        int ci = 0;
        for (int i = num.length-1; i >= 0; i--) {
            int y = num[i]-'0'+ci;
            if (i == num.length-1) { //数字+1，即数组的最后一位+1
                y++;
            }
            if (y >= 10) { //产生进位的情况
                if (i == 0) { //最高位产生进位
                    isOverflow = true;
                } else {
                    ci = 1;
                    num[i]=(char) ((y-10)+'0');
                }
            } else { //没有产生进位
                num[i] = (char) (y+'0');
                break;
            }
        }
        return isOverflow;
    }

    public int saveNumber(char[] num) {
        //将字符数组转为int类型的数字
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
           sum = sum * 10 + (num[i]-'0');
        }
        return sum;
    }

    //递归 直接打印
    public void printNumbers3(int n) {
        if (n <= 0) {
            return;
        }

        char [] charNum = new char[n];
        for (int i = 0; i < 10; i++) {
            charNum[0] = (char) (i+'0');
            printNumbersHelper(charNum, n, 0);
        }
    }

    public void printNumbersHelper(char[] chars, int len, int index) {
        if (index == len-1) {
            System.out.println(Arrays.toString(chars));
            return;
        }

        for (int i = 0; i < 10; i++) {
            chars[index+1] = (char) (i+'0');
            printNumbersHelper(chars, len, index+1);
        }
    }

    public static void main(String[] args) {
        $17 a = new $17();
        char[] num = {'9','9','9'};
        char[] num2 = {'7','8','9'};
//        System.out.println(a.increment(num));
//        System.out.println(a.increment(num2));

//        int[] res = new int[2];
//        int cnt = 0;
//        res[cnt++] = a.saveNumber(num);
//        res[cnt] = a.saveNumber(num2);
//        System.out.println(" res = " + Arrays.toString(res));

        //System.out.println(Arrays.toString(a.printNumbers2(2)));

        a.printNumbers3(2);
    }
}
