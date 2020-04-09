import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashMap_ <K,V> {

    private class Node {
        K key ;
        V value;
        public Node(K key ,V value){
           this.key=key;
           this.value=value;
        }

        @Override
        public String toString(){
            return this.key+"="+this.value;
        }

    }

    private LinkedList<Node> [] bucketArray;
    private int size ;
    private static final int DEFAULT_CAPACITY =10;




    public HashMap_(){
        this(DEFAULT_CAPACITY);
    }

    public HashMap_(int capacity){
        this.bucketArray =  new LinkedList [capacity];
        this.size=0;
    }

    public int size(){
        return this.size;
    }



    public V get(K key){
        int bi =hashFunction(key);
        LinkedList<Node> bucket =this.bucketArray[bi];
        if(bucket==null) return null;
        Node node =findKey(bucket, key);
        return node==null ? null :node.value; 
    }

    public boolean containsKey(K key){

        int bi = hashFunction(key);
        LinkedList<Node> bucket = bucketArray[bi];
        if(bucket==null) return false;
        Node node= findKey(bucket, key);
        if(node==null) return false;
        return true; 
        
    }

    public Integer getOrDefault(int key,int def ){
        if(this.containsKey(key)) return this.get(key);
        return def;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public void put(Integer key ,Integer value){
        int bi = hashFunction(key);
        Node node = new Node(key, value);
        LinkedList<Node> bucket =bucketArray[bi];
        if(bucket==null){
            bucket = new LinkedList<>();
            bucket.addLast(node);
            bucketArray[bi]=bucket;
            this.size++;
        }else{
            Integer fVal = findKey(bucket, key);
            if(fVal==null){
              bucket.addLast(node);
              this.size++;
            }else{
              bucket.removeFirst();
              bucket.addFirst(node);
            }
        }

        double lambda = bucket.size()*1.0/ this.bucketArray.length;
        if(lambda>0.3){
            System.out.println("rehash called");
            reHash();
        }
    }

    public List<Integer> keySet(){
        List<Integer> ans = new ArrayList<>();
        for(LinkedList<Node> bucket :this.bucketArray){
           if(bucket!=null&&bucket.size()!=0){
               int s =bucket.size();
               while(s>0){
                   s--;
                   Node rm =bucket.removeFirst();
                   ans.add(rm.key);
                   bucket.addLast(rm);
               }
           }
        }
        return ans;
    } 

    public void reHash(){
        LinkedList<Node>[] oba = this.bucketArray;
        this.bucketArray = new LinkedList [oba.length*2];
        this.size =0;
        for( LinkedList<Node> bucket : oba ){
            while(bucket!=null&&!bucket.isEmpty()){
                Node top =bucket.removeLast();
                this.put(top.key, top.value);
            }
        } 
    }

    public void remove(Integer key){
        int bi =hashFunction(key);
        LinkedList<Node> bucket = bucketArray[bi];
        if(bucket==null) return ;
        else{
            Integer fVal = findKey(bucket, key);
            if(fVal==null) return ;
            bucket.removeFirst();
            this.size--;
        }
    }


    private Node findKey(LinkedList<Node> bucket ,K key){
        int size = bucket.size();
        while(size>0){
            size--;
            if(bucket.getFirst().key==key){
                return bucket.getFirst();
            }
            bucket.addLast(bucket.removeFirst());
        }

        return null;
    } 

    private int hashFunction(K key){
        int bi = key.hashCode();
        bi =Math.abs(bi) % this.bucketArray.length;
        return bi;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for(LinkedList<Node> bucket : this.bucketArray ){
            if(bucket!=null&&bucket.size()>0){
                int size = bucket.size();
                while(size>0){
                    size--;
                    Node pair = bucket.removeFirst();
                    sb.append(pair.toString()+",");
                    bucket.addLast(pair);
                }
            }
        }
        sb.append(" }");
        return sb.toString();
    }
}