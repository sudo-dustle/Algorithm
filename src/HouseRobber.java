public class HouseRobber {
    public static int[][] memoi = new int[401][2];

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        rob(nums);
    }

    public static int rob(int[] nums) {
        for (int i = 0; i < memoi.length; i++) {
            memoi[i][0] = Integer.MIN_VALUE;
            memoi[i][1] = Integer.MIN_VALUE;
        }

//        int answer = recursive(nums, 0, 0);
        int answer = dp(nums);
        System.out.println(answer);
        return answer;
    }

    public static int dp(int[] nums) {
        memoi[0][0] = nums[0];
        memoi[0][1] = 0;

        for(int i = 1; i < nums.length; i++) {
            memoi[i][0] = Math.max(memoi[i-1][1] + nums[i], memoi[i-1][0]);
            memoi[i][1] = memoi[i-1][0];
        }

        return Math.max(memoi[nums.length - 1][0], memoi[nums.length - 1][1]);
    }

//    public static int recursive(int[] nums, int index, int flag) {
//        if (index >= nums.length) {
//            return 0;
//        }
//
//        if (memoi[index][flag] != Integer.MIN_VALUE) {
//            return memoi[index][flag];
//        }
//
//        if (flag == 0) {//전 집에 방문하지 않았다면 -> 더하기
//            memoi[index][flag] = nums[index] + recursive(nums, index + 1, 1);
//        }
//        memoi[index][flag] = Math.max(recursive(nums, index + 1, 0), memoi[index][flag]);
//
//        return memoi[index][flag];
//    }
}
