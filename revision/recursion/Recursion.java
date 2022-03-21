import java.util.Arrays;

public class Recursion {

    public static void main(String[] args) {

    //     String str1 = "send";
    //     String str2 = "more";

    //     String str3 = "money";
    //     // CryptoSolve(str1,str2,str3);

    //     int[] nums = { 2, 3, 5, 7, 8 };
    //     //coinChangePermutation_ItrWay(10, "", nums);
    //    //coinChangePermutation_SubSeqWay(0, 10, "", nums);
    //    coinChangeCombination_ItrWay(10, 0, "", nums);

          int n = 10;
          int m = 6;

          int [] dp =new int [n+1];

          int ans = TilingProblem(n, m,dp);

          System.out.println(Arrays.toString(dp));
          System.out.println(ans);
    }

    public static void CryptoSolve(String str1, String str2, String str3) {
        // print the decoding

        int[] freqMap = new int[26];
        boolean[] visited = new boolean[10];

        Arrays.fill(freqMap, -2);

        StringBuilder uniques = new StringBuilder();

        // get uniques for string 1
        for (int i = 0; i < str1.length(); i++) {
            char cc = str1.charAt(i);
            if (freqMap[cc - 'a'] != -1) {
                freqMap[cc - 'a'] = -1;
                uniques.append(cc);
            }
        }

        // get uniques for str2
        for (int i = 0; i < str2.length(); i++) {
            char cc = str2.charAt(i);
            if (freqMap[cc - 'a'] != -1) {
                freqMap[cc - 'a'] = -1;
                uniques.append(cc);
            }
        }

        // get uniques for str3
        for (int i = 0; i < str3.length(); i++) {
            char cc = str3.charAt(i);
            if (freqMap[cc - 'a'] != -1) {
                freqMap[cc - 'a'] = -1;
                uniques.append(cc);
            }
        }

        recursionCrypto(uniques, 0, freqMap, visited, str1, str2, str3);
    }

    public static void recursionCrypto(StringBuilder str, int i, int[] freqMap, boolean[] visited, String str1,
            String str2, String str3) {

        if (i == str.length()) {

            int addition = addStrings(str1, str2, freqMap);
            int numbFormed = getNumFromString(str3, freqMap);

            // System.out.println("Addition is "+addition+", numbFormed is "+numbFormed);

            if (addition == numbFormed) {
                // print map
                for (int k = 0; k < freqMap.length; k++) {

                    if (freqMap[k] != -2) {
                        char cc = (char) ('a' + k);
                        System.out.println(cc + ":" + freqMap[k]);
                    }
                }
                System.out.println("***************************");
            }
            return;

        }

        char cc = str.charAt(i);

        for (int num = 0; num < visited.length; num++) {

            // check if can be assigned
            if (!visited[num]) {
                freqMap[cc - 'a'] = num;
                visited[num] = true;
                recursionCrypto(str, i + 1, freqMap, visited, str1, str2, str3);
                freqMap[cc - 'a'] = -1;
                visited[num] = false;
            }
        }
    }

    public static int addStrings(String str1, String str2, int[] freqMap) {
        int count = 0;
        int num = 0;

        int fp = str1.length() - 1;
        int sp = str2.length() - 1;

        int carry = 0;

        while (fp >= 0 && sp >= 0) {
            int sum = carry + freqMap[str1.charAt(fp) - 'a'] + freqMap[str2.charAt(sp) - 'a'];
            int digitToPlace = sum % 10;
            carry = sum / 10;
            num = (digitToPlace * (int) Math.pow(10, count)) + num;
            count++;

            fp--;
            sp--;
        }

        while (fp >= 0) {
            int sum = carry + freqMap[str1.charAt(fp) - 'a'];
            int digitToPlace = sum % 10;
            carry = sum / 10;
            num = (digitToPlace * (int) Math.pow(10, count)) + num;
            count++;
            fp--;
        }

        while (sp >= 0) {
            int sum = carry + freqMap[str1.charAt(sp) - 'a'];
            int digitToPlace = sum % 10;
            carry = sum / 10;
            num = (digitToPlace * (int) Math.pow(10, count)) + num;
            count++;
            sp--;
        }
        return num;
    }

    public static int getNumFromString(String str, int[] freqMap) {
        int num = 0;

        for (int i = 0; i < str.length(); i++) {
            int digit = freqMap[str.charAt(i) - 'a'];
            num = num * 10 + digit;
        }

        return num;
    }

    public static void coinChangePermutation_ItrWay(int sum, String ans, int[] nums) {

        if (sum == 0) {
            System.out.println(ans.substring(1));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] >= 0) {
                coinChangePermutation_ItrWay(sum - nums[i], ans + "," + nums[i], nums);
            }
        }

    }

    public static void coinChangePermutation_SubSeqWay(int idx, int sum, String ans, int[] nums) {

        if ( sum == 0) {
            System.out.println(ans);
            return;
        }

        if(idx == nums.length ){
            return;
        }

        // select

        if (sum - nums[idx] >= 0) {
            coinChangePermutation_SubSeqWay(0, sum - nums[idx], ans + "," + nums[idx], nums);
        }

        // not select
        coinChangePermutation_SubSeqWay(idx+1, sum, ans, nums);

    }



    public static void coinChangeCombination_ItrWay(int sum,int idx,String ans, int[] nums) {

        if(idx == nums.length){
            if (sum == 0) {
                System.out.println(ans);
                return;
            }
        }

        if (sum == 0) {
            System.out.println(ans);
            return;
        }
       
        for (int i = idx ; i < nums.length; i++) {
            if (sum - nums[i] >= 0) {
                coinChangeCombination_ItrWay(sum-nums[i], i+1, ans+","+nums[i], nums);
            }
        }

    }




    public static int TilingProblem(int n,int m,int []dp){

        if ( n == m ){
            return dp[n] =2;
        }

        if( n < m ){
            return dp[n]= 1;
        }
        int ans = 0;
        ans += TilingProblem(n-1, m,dp);
        ans += TilingProblem(n-m, m,dp);
        return dp[n] = ans;
    }



}



