/**
 * 1+2+……+n
 * 法一：构造函数 不成功
 * 法二：虚函数
 * 法三：函数指针
 * 法四：模板类型
 * 法五：短路求值
 */
public class $64 {
    static int x = 0;
    static int sum = 0;

    public $64() {
        x++;
        sum += x;
        System.out.println("hello ");
    }

    public static void reset() {
        x = 0;
        sum = 0;
    }

    public static int getSum(){
        return sum;
    }


    public static int sumNums(int n) {
        reset();
        //$64 a = new $64();
        $64[] a = new $64[n];

        return getSum();
    }


    public static int sumNums2(int n) {
        boolean x = n > 1 && (n += sumNums2(n-1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }
}
