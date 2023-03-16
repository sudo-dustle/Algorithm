import java.util.Arrays;

public class SingleElementsInASortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        int i = singleNonDuplicate(nums);
        System.out.println(i);
    }

    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m;

        while (l < r) {
            m = (r + l) / 2;
            System.out.println(m);

            if (determine(nums, m)) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return nums[l];
    }

    private static boolean determine(int[] nums, int m) {
        if (m % 2 == 0) {
            if (nums[m] == nums[m + 1]) {
                return true;
            }
        } else {
            if (nums[m] == nums[m - 1]) {
                return true;
            }
        }

        return false;
    }
}
