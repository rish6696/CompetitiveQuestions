import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    public static class Node {
        int val;
        List<Node> neighbors;

        public Node(int val){
         this.val=val;
         neighbors=new ArrayList<>();
        }
    } 

    public static void main(String[] args) {
        HashMap<Integer,Node> map=new HashMap<>();

        
    }

    public static void createNode(Node node,HashMap<Integer,Node>map){
       Node newNode =new Node(node.val);
       map.put(node.val,newNode);
       for(Node e:node.neighbors){
           if(!map.containsKey(e.val)){
               createNode(e, map);
           }
       }
    }

    public static void updateNeighbours(Node node,HashMap<Integer,Node>map,HashMap<Integer,Boolean>visited){
        visited.put(node.val, true);
        Node newNode=map.get(node.val);
        visited.put(node.val, true);
        for(Node e:node.neighbors){
           newNode.neighbors.add(map.get(e.val));
        }

        for(Node e:node.neighbors){
            if(!visited.containsKey(e.val)){
                updateNeighbours(e, map, visited);
            }
        }
    }

    
   

    
}