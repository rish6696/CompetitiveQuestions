public class Trie{
    private class Node {
        Node[] childs;
        int endCount ;

        public Node(int endCount){
           this.childs= new Node [26];
           endCount=0;
        }
    }

    Node root;
    public Trie(){
        this.root=new Node(0);
    }

    public void insert(String word){
       Node curr = this.root;
       for(int i =0;i<word.length();i++){
          int idx = word.charAt(i)-'a';
          if(curr.childs[idx]==null){
             curr.childs[idx]= new Node(0);
          }
          curr = curr.childs[idx];
       }
       curr.endCount++;
    }


    public boolean search(String word){
       Node curr = this.root;
       for(int i =0;i<word.length();i++){
          int idx = word.charAt(i)-'a';
          if(curr.childs[idx]==null) return false;
          curr = curr.childs[idx];
       }
       return curr.endCount >0 ;
    }

     public boolean strWith(String word){
       Node curr = this.root;
       for(int i =0;i<word.length();i++){
          int idx = word.charAt(i)-'a';
          if(curr.childs[idx]==null) return false;
          curr = curr.childs[idx];
       }
       return true;
      
    }

}