import java.util.Arrays;

/**
 * 数组中数字出现的次数
 * 数组中只有两个数字（x y）只出现一次，其余都出现了两次，
 * 思路：把原数组分为两个数组，每个数组中只包含一个只出现一个的数字
 * 步骤：1.从头到尾依次异或数组中的数字（得到的结果ans就是x^y）
 *      2.在结果ans中找到从右往左数第一个出现1的位置，记为第n位
 *      3.根据第n位是否为1，将数组中的数字分为两组
 *      4.每个子数组异或，找到只出现一次的数字
 */

public class $56i {
    public static int[] singleNumbers(int[] nums) {
        int[] res = new int[2];

        //1.从头到尾依次异或数组中的数字（得到的结果ans就是x^y）
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }

        //2.在结果ans中找到从右往左数第一个出现1的位置，记为第n位
        int n = 0;
        while ((ans & 1) == 0) {
            ans >>= 1;
            n++;
        }

        for (int i = 0; i < nums.length; i++) {
            //3.根据第n位是否为1，将数组中的数字分为两组
            if ((nums[i] >> n & 1) == 1) { //错误点：nums[i] >> n == 1
                //4.每个子数组异或，找到只出现一次的数字
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6,5,5,9,10,9,4,10};
        //int[] nums = {4,1,4,6};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
}
