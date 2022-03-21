public class Dp {
    public static void main(String[] args) {

        // int ans = inDivideInKGroups(4,2);
        // System.out.println(ans);

        int[] nums = { 2 ,Integer.MAX_VALUE};
        System.out.println(upperBound(nums, 2));

    }

    public static class Pair implements Comparable<Pair> {

        @Override
        public int compareTo(Dp.Pair o) {
            // TODO Auto-generated method stub
            return 0;
        }

    }

    public static int inDivideInKGroups(int n, int k) {

        if (k > n) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        int ans = 0;
        int newGroup = inDivideInKGroups(n - 1, k - 1);

        int adjustInComingGroups = inDivideInKGroups(n - 1, k);

        ans = newGroup + (k * adjustInComingGroups);
        return ans;
    }

    public static int upperBound(int[] nums, int find) {
        int l = 0;
        int r = nums.length - 1;

        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (l == r) {
                return nums[l] == find ? l+1 : l;
            }

            ans = mid;
            int curr = nums[mid];

            if (curr > find) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

}