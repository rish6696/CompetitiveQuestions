
public class Client {
  public static void main(String[] args) {
      Trie dic = new Trie();
      dic.insert("apple");
      dic.insert("mango");
      dic.insert("app");
      dic.insert("apply");

      System.out.println(dic.search("apple"));
      System.out.println(dic.search("mango"));
      System.out.println(dic.search("app"));
      System.out.println(dic.search("apply"));

      System.out.println(dic.search("apilockle"));
      System.out.println(dic.strWith("applem"));

  }
}