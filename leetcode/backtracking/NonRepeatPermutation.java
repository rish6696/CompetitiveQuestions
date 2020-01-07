public class NonRepeatPermutation {
    public static void main(String[] args) {

        String a = "AAABBC";
        int c = 0;
         for (int i = 0; i < a.length(); i++) {
             c += nonRepeatPermutation(a, 1, i + 1, "");
         }
        System.out.println(c);

    }

    public static int nonRepeatPermutation(String ques, int k, int t, String ans) {
        if (k == t + 1) {
            System.out.println(ans);
            return 1;
        }
        int a = 0;
        int c = 0;
        for (int i = 0; i < ques.length(); i++) {
            char cc = ques.charAt(i);
            int v = cc - 'A';
            if ((a & (1 << v)) == 0) {
                a |= 1 << v;
                c += nonRepeatPermutation(ques.substring(0, i) + ques.substring(i + 1), k + 1, t, ans + cc);
            }
        }
        return c;
    }
}