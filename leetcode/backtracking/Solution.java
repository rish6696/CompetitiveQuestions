public class Solution{
    public static void main(String[] args) {
        CombinationIterator itj=new CombinationIterator("abc", 2);
        System.out.println(itj.next());
        System.out.println(itj.next());
        System.out.println(itj.next());
        System.out.println(itj.hasNext());
    }
}