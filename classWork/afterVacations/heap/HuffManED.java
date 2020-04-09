import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffManED {

    private class Node implements Comparable<Node> {

        String data;
        int freq ;
        Node right ;
        Node left ;

        public Node(String data,int freq,Node left,Node right){
            this.data=data;
            this.freq=freq;
            this.right=left;
            this.left=right;
        }

        @Override 
        public int compareTo(Node o){
            return this.freq - o.freq;
        }
    }

    private HashMap<String,String> enCode ;
    private HashMap<String,String> deCode ;
    private  PriorityQueue<Node> queue ;
    private  Node root =null;

    public HuffManED(int [] arr ){
       enCode = new HashMap<>();
       deCode = new HashMap<>();
       queue = new PriorityQueue<>();

       for (int i = 0; i < arr.length; i++) {
           char cc = (char) (97 +i);
           queue.add(new Node(cc+"", arr[i], null, null));
       }

       this.root = createTree();
       enCode(this.root,"");

    }


    private void enCode(Node root,String code){

       if(root.left== null && root.right ==null) {
           enCode.put(root.data, code);
           deCode.put(code, root.data);
           return ;
       } 
       enCode(root.left,code+"0");
       enCode(root.right,code+"1");

    }


    private Node createTree(){

       while(queue.size()>1){
           Node f = queue.poll();
           Node s =queue.poll();
           queue.add(new Node(f.data+s.data, f.freq+s.freq , f ,s ));
        }

        return queue.poll();
    }

    public String enCodeString(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(enCode.get(str.charAt(i)+""));
        }
        return sb.toString();
    }

    public String deCodeString(String str){
        StringBuilder sb = new StringBuilder();
        int start =0;
        for (int i = 0; i < str.length(); i++) {
            
            if(deCode.containsKey(str.substring(start,i+1))){
                sb.append(deCode.get(str.substring(start,i+1)));
                start=i+1;
            }  
        }
        return sb.toString();
    }



}