public class _InsertDeleteGetRandomDuplicatesallowed {

    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        System.out.println(r.insert(0));
        System.out.println(r.remove(0));
        System.out.println(r.insert(-1));
        System.out.println(r.remove(0));

        System.out.println(r.getRandom());
    }
}