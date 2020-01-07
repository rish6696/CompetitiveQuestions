public class Additivenumber {
    public static void main(String[] args) {

        String num = "9910011992";
         System.out.println(sequence(num, 1, "-1", "-1", ""));
       // System.out.println(addBigStrings("1","9"));

    }

    public static boolean isValidString(String str) {
        if (str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }
        return true;
    }


    public static String addBigStrings(String big,String small){
        if(big.length()<small.length())return addBigStrings(small, big);
        String ans ="";
        int i=big.length()-1;
        int j=small.length()-1;
        int carry=0;
        while(i>=0&&j>=0){
            int bigVal=big.charAt(i)-'0';
            int smallVal=small.charAt(j)-'0';
            int sum =bigVal+smallVal+carry;
           // String sumString=sum+"";
            carry=sum/10;
            ans=(sum%10)+ans;
            i--;
            j--;

        }

        while(i>=0){
            int bigVal=big.charAt(i)-'0';
            int sum =bigVal+carry;
            // String sumString=sum+"";
             carry=sum/10;
             ans=(sum%10)+ans;
             i--;
            
        }
        if(carry!=0){
            ans=carry+ans;
        }
        
        return ans;


    }

    public static boolean sequence(String num, int counter, String  f, String s, String ans) {
        if (num.length() == 0&&counter>3) {
            System.out.println(ans);
            return true;
        }
        for (int i = 0; i < num.length(); i++) {
            String temp = num.substring(0, i + 1);
            if (!isValidString(temp))
                return false;
           // int tempVal = Integer.parseInt(temp);
            if (counter == 1 || counter == 2) {
                String fval = counter == 1 ? temp : f;
                String sval = counter == 2 ? temp : s;
                boolean recAns = sequence(num.substring(i + 1), counter + 1, fval, sval, ans + temp + " ");
                if (recAns)
                    return true;
            } else {
                String target = addBigStrings(f, s);
                if (target.equals(temp)) {
                    boolean recAns = sequence(num.substring(i + 1), counter + 1, s, temp, ans + temp + " ");
                    if (recAns)
                        return true;
                }
            }
        }
        return false;
        
    }
}