public class $3 {
    public int findRepeatNumber(int[] nums) {
        int[] map = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
        }
        for (int j = 0;  j < nums.length; j++) {
            if (map[j] > 1) {
                return j;
            }
        }
        return -1; //没找到
    }
}
