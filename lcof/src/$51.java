import java.util.Arrays;

public class $51 {
    public static int reversePairs(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        return reversePairsHelper(nums, 0, nums.length);
    }

    public static int  reversePairsHelper(int[] nums, int left, int right) {
        if (left > right || right - left == 1) {
            return 0;
        }

        int mid = (right + left) / 2;
        int x = reversePairsHelper(nums, left, mid);
        int y = reversePairsHelper(nums, mid, right);

        int z = mergeAndCount(nums, left, mid, right);
        return x + y + z;
    }

    //从后往前合并
    public static int mergeAndCount(int[] nums, int left, int mid, int right) {
        int i = mid-1;
        int j = right-1;
        int cnt = 0;

        int[] extra = new int[right-left];
        int k = extra.length-1;

        while (i >= left && j >= mid) {
            if (nums[i] > nums[j]) {
                extra[k--] = nums[i--];
                cnt += j - mid + 1;
            } else {
                extra[k--] = nums[j--];
            }
        }

        while (i >= left) {
            extra[k--] = nums[i--];
        }

        while (j >= mid) {
            extra[k--] = nums[j--];
        }

        for (int x = 0; x < extra.length; x++) {
            nums[x+left] = extra[x];
        }

        return cnt;
    }


    //先写一个合并排序 ~
    public static void mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length);
    }

    public static void mergeSortHelper(int[] nums, int left, int right) {
        while (left > right || right - left == 1) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSortHelper(nums, left, mid);
        mergeSortHelper(nums, mid, right);
        merge(nums, left, mid, right);
        //mergeAndCount(nums, left, mid, right);
    }


    public static void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int[] extra = new int[right - left];
        int k = 0;

        while (i < mid && j < right) {
            if (nums[i] < nums[j]) {
                extra[k++] = nums[i++];
            } else {
                extra[k++] = nums[j++];
            }
        }

        while (i < mid) {
            extra[k++] = nums[i++];
        }

        while (j < right) {
            extra[k++] = nums[j++];
        }

        for (int t = 0; t < extra.length; t++) {
            nums[left+t] = extra[t];
        }
    }

    public static void main(String[] args) {
//        int[] nums = {8,4,6,7,1,2,9,5,3};
//        mergeSort(nums);
//        System.out.println(Arrays.toString(nums));

        int[] nums2 = {7,5,6,4};

        System.out.println(reversePairs(nums2));
        System.out.println(Arrays.toString(nums2));
    }

}

//根据该大佬解法，修改了自己的解法
class Solution {
    public static int reversePairs(int[] nums) {
        int len=nums.length;
        if (len==0) {
            return 0;
        }
        return digui(nums,0,len-1);
    }

    public static int digui(int[] nums,int left,int right){
        if(left>=right) {
            return 0;
        }
        int mid=(right+left)>>1;
        int l=digui(nums,left,mid);//记录左边的结果
        int r=digui(nums,mid+1,right);//记录右边的结果
        int z=mergesort(nums,left,mid,right);
        System.out.println(" l = " + l + " r = " + r + " z = " + z);
        return (l+r+z);//左+右+当前

    }

    public static int mergesort(int[]nums,int left,int mid,int right){
        int[]temp=new int[right-left+1];//left和right都可以取到，所以需要加1
        int ans=0;
        int cur1=mid;
        int cur2=right;
        int cur3=right-left;
        while(cur1>=left&&cur2>=mid+1){
            if(nums[cur1]<=nums[cur2]){
                temp[cur3--]=nums[cur2--];
            }
            else{
                temp[cur3--]=nums[cur1--];
                ans+=(cur2-mid); //比当前cur2里面的元素都大
            }
        }
        while(cur1>=left){
            temp[cur3--]=nums[cur1--];
        }
        while(cur2>=mid+1){
            temp[cur3--]=nums[cur2--];
        }
        int x=0;
        while(left<=right){
            nums[left++]=temp[x++];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums2 = {7,5,6,4};

        System.out.println(reversePairs(nums2));
        //mergeSort(nums2);
        System.out.println(Arrays.toString(nums2));
    }

}

//此解法不能理解，为什么需要copy[]
class Solution2 {

    public int reversePairs(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        return reversePairs(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right] 计算逆序对个数并且排序
     */
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // 如果整个数组已经有序，则无需合并，注意这里使用小于等于
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    /**
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++) {
            // 有下标访问，得先判断是否越界
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 注意：这里是 <= ，写成 < 就不对，请思考原因
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;

                // 在 j 指向的元素归并回去的时候，计算逆序对的个数，只多了这一行代码
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
