
public class DoublyLinkedList {

    public  class ListNode {
       ListNode next;
       ListNode prev;
       int data;
       public ListNode(int data){
           this.data=data;
           this.prev=null;
           this.next = null;
       } 
    }

    private ListNode head;
    private ListNode tail;
    private int size=0;




    //function that are required 
    //1. void addFirst()
    //2. void removelast()
    //3. void removeNode(ListNode node)

    public int getLast(){
        if(this.size()==0) return -1;
        return this.tail.data;
    }

    public DoublyLinkedList(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    public int size(){
        return this.size;
    }

    public  boolean isLastAndSecondLastSame(){
       if(this.size()<2) return false;
       return this.tail.data == this.tail.prev.data;
    }


    public ListNode addFirst(int data){
        ListNode node = new ListNode(data);
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

    public void addLast(int data){
        ListNode node = new ListNode(data);
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
            sb.append(temp.data+",");
            temp=temp.next;
        }
        if(sb.length()!=1) sb.deleteCharAt(sb.length()-1);

        sb.append("]");
        return sb.toString();
    }

}   