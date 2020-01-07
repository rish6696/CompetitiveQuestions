import java.util.Arrays;

public class ClosetSum {
    public static void main(String[] args) {
        int[] nums = { 1 ,1, 1 ,0 };
        System.out.println(closetSum(nums, -100));

    }

    public static int closetSum(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int one = 0, sec = 0, third = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int tempTarget = target - val;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int d;
                if (sum == tempTarget) {
                    return tempTarget + val;
                } else if (sum > tempTarget) {
                    d = sum - tempTarget;
                    if (d < diff) {
                        one = val;
                        sec = nums[left];
                        third = nums[right];
                        diff=d;
                    }
                    right--;
                } else {
                    d = tempTarget - sum;
                    if (d < diff) {
                        one = val;
                        sec = nums[left];
                        third = nums[right];
                        diff=d;
                    }
                    left++;

                }

            }

        }
        return one + sec + third;
    }
}