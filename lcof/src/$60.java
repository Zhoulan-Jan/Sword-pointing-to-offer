import java.util.ArrayList;
import java.util.Arrays;

/**
 * n个骰子的点数
 */
public class $60 {
    public double[] dicesProbability(int n) {
        double[] res = new double[5*n+1];
        int[] tmp = new int[5*n+1];
        if (n < 1) {
            return null;
        }

//        probability(n, tmp);
        for (int i = 1; i <= 6; i++) {
            helper(n, n, i, tmp);
        }

        double total = Math.pow(6, n);
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp[i] * 1.0 / total;
        }

        return res;
    }

    public void probability(int n, int[] nums) {
        for (int i = 1; i <= 6; i++) {
            helper(n, n, i, nums);
        }
    }

    public void helper(int original, int current, int sum, int[] nums) {
        if (current == 1) {
            nums[sum-original]++;
        } else {
            for (int i = 1; i <= 6; i++) {
                helper(original, current-1, i+sum, nums);
            }
        }
    }

    public static void main(String[] args) {
        $60 a = new $60();
        System.out.println(Arrays.toString(a.dicesProbability(2)));
    }
}
