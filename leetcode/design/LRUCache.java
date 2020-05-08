import java.util.*;
public class LRUCache {

    public  class ListNode {
        ListNode next;
        ListNode prev;
        int key;
        int value;
        public ListNode(int key,int value){
            this.key=key;
            this.value=value;
            this.prev=null;
            this.next = null;
        } 
     }
 

public class DoublyLinkedList {

    
    private ListNode head;
    private ListNode tail;
    private int size=0;




    //function that are required 
    //1. void addFirst()
    //2. void removelast()
    //3. void removeNode(ListNode node)

    public ListNode getLast(){
        return this.tail;
    }

    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public int size(){
        return this.size;
    }

    public ListNode addFirst(ListNode node ){
        if(this.tail==null&&this.head==null){
            this.head=node;
            this.tail=node;
        }else{
            this.head.prev=node;
            node.next= this.head;
            this.head=node;
        }
        this.size++;
        return node;
    }

    public void breakNode(ListNode node){
        if(node==null) return ;
        if(node==this.tail){
            this.tail = node.prev;
        }
        if(node==this.head){
            this.head=node.next;
        }
        if(node.next!=null) node.next.prev=node.prev;
        if( node.prev!=null ) node.prev.next=node.next;
        this.size--;
    }

    
    public ListNode addFirst(int key,int value){
        ListNode node = new ListNode(key,value);
        return addFirst(node); 
    }

    public void addLast(int key,int value){
        ListNode node = new ListNode(key,value);
        if(this.tail==null&&this.head==null){
            this.head=node;
            this.tail=node;
        }else{
           node.prev=this.tail;
           tail.next=node;
           this.tail=node;
        }
        this.size++;
    }

    public void removeLast(){
        if(this.size()==0) return;
        if(this.tail.prev!=null) this.tail.prev.next=null;
        this.tail=this.tail.prev;
        if(this.size==1) this.head=null;
        this.size--;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        ListNode temp =this.head;
        sb.append("[");
        while(temp!=null){
            sb.append(temp.key+"/"+temp.value+",");
            temp=temp.next;
        }
        if(sb.length()!=1) sb.deleteCharAt(sb.length()-1);

        sb.append("]");
        return sb.toString();
    }

}   
     
    DoublyLinkedList list;
    HashMap<Integer,ListNode> map;
    int capacity=0;

    public LRUCache(int capacity) {
        this.list = new DoublyLinkedList();
        this.map  =  new  HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        list.breakNode(node);
        node.next=null;
        node.prev=null;
        list.addFirst(node);
        return node.value;
    }



   

    public void put(int key, int value) {
        // abhi check krna h ki kahi exist to nhi karti'

        if(map.containsKey(key)){
           ListNode node = map.get(key);
           node.value=value;
           list.breakNode(node);
           node.next=null;
           node.prev=null;
           list.addFirst(node);
           return;
        }

        if(list.size()==this.capacity){
            ListNode last = list.getLast();
            if(last!=null) map.remove(last.key);
            list.removeLast();
        }
        ListNode node =list.addFirst(key,value);
        map.put(key, node);
    }
}
