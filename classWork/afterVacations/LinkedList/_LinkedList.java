import java.util.Stack;
public class _LinkedList {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        public String toString() {
            return this.val + "==>";
        }
    }

    ListNode head;
    ListNode tail;
    int ListNodeCount = 0;

    public _LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return this.ListNodeCount;
    }

    public boolean isEmpty() {
        return this.ListNodeCount == 0;
    }

    private ListNode getListNodeAt(int idx) throws Exception {
        if (idx < 0 || idx >= this.size())
            throw new Exception("Invalid Index");
        ListNode curr = this.head;
        while (idx > 0) {
            idx--;
            curr = curr.next;
        }
        return curr;
    }

    public int getAt(int idx) throws Exception {
        return this.getListNodeAt(idx).val;
    }

    public void addFirst(int val) {
        ListNode ListNode = new ListNode(val);
        this.ListNodeCount++;
        if (this.head == null) {
            this.head = ListNode;
            this.tail = ListNode;
        } else {
            ListNode.next = this.head;
            this.head = ListNode;
        }
    }

    public void addLast(int val) {
        ListNode ListNode = new ListNode(val);
        if (this.size() == 0) {
            this.head = ListNode;
            this.tail = ListNode;
        } else {
            this.tail.next = ListNode;
            this.tail = ListNode;
        }
        this.ListNodeCount++;
    }

    public void addAt(int idx, int val) throws Exception {
        if (idx < 0 || idx > this.size())
            throw new Exception("Invalid index");

        if (idx == 0)
            addFirst(val);

        else if (idx == this.size())
            addLast(val);

        else {
            this.ListNodeCount++;
            ListNode ListNode = new ListNode(val);
            ListNode prev = getListNodeAt(idx - 1);
            ListNode.next = prev.next;
            prev.next = ListNode;
        }
    }

    public int getFirst() throws Exception {
        if (this.size() == 0)
            throw new Exception("List is empty");
        return this.head.val;
    }

    public int getLast() throws Exception {
        if (this.size() == 0)
            throw new Exception("List is empty");
        return this.tail.val;
    }

    

    public int removeFirst() throws Exception{
        if(this.size()==0) throw new Exception("Empty list");
        return removeFirstListNode().val;

    }
    private ListNode removeFirstListNode(){
        ListNode rn = this.head;
        this.ListNodeCount--;
        if(this.size()==1){
          this.head=null;
          this.tail =null; 
        }else{
            this.head=this.head.next;
        }
        return rn;
    }



    public int removeLast() throws Exception{
        if(this.size()==0) throw new Exception("Empty list");
        return removeLastListNode().val;

    }
    private ListNode removeLastListNode() throws Exception {
        ListNode rn = this.tail;
        this.ListNodeCount--;
        if(this.size()==1){
          this.head=null;
          this.tail =null; 
        }else{
            ListNode prev =getListNodeAt(this.size()-2);
            prev.next=null;
            this.tail=prev;
        }
        return rn;
    }


    public int removeAt(int idx) throws Exception {

        if(this.isEmpty()) throw new Exception("List is empty");
        if(idx< 0 || idx >=this.size()) throw new Exception("Invalid index");

        if(idx==0) return removeFirstListNode().val;
        else if(idx==this.size()-1) return removeLastListNode().val;

        return removeAtListNode(idx).val;
    }


    private ListNode removeAtListNode (int idx)  throws Exception {
        ListNode prev = getListNodeAt(idx-1);
        ListNode rn = prev.next;
        prev.next = prev.next.next;
        this.ListNodeCount--;
        return rn;
    } 


    public void display(){
       ListNode curr=this.head;
       while(curr!=null){
           System.out.print(curr);
           curr=curr.next;
       }
       System.out.print("NULL");
       System.out.println();
    }

    public void reversePtr(){
        if(this.head==null) return ;
        ListNode prev =this.head;
        ListNode curr =head.next;
        head.next=null;
        while(curr!=null){
            ListNode newNext = curr.next;
            curr.next=prev;
            prev =curr;
            curr=newNext;
        }
        this.head=prev;
    }



    public void createCycle(int idx)throws Exception{
        ListNode node = getListNodeAt(idx);
        this.tail.next=node;
    }

    public boolean detectCycle(){
        if(this.head==null)  return false;
        ListNode slow = this.head;
        ListNode fast =this.head;

        while(fast.next!=null&&fast.next.next!=null&&slow.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }

    public int getCycle(){
        return getCycleNode(this.head).val;
    }

    private ListNode getCycleNode(ListNode head) {
        if(head==null)  return null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null&&fast.next.next!=null&&slow.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println(slow.val);
                slow= head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }


    public void intersectList(_LinkedList other,int idx)throws Exception{
        other.tail.next=this.getListNodeAt(idx);
    }


    public int detectintersection(_LinkedList other){
        return getIntersectionNode(this.head, other.head).val;
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        
        ListNode tail= headB;
        
        while(tail.next!=null) tail =tail.next;
        
        tail.next = headB;
        ListNode ans = getCycle(headA);
        tail.next =null;
        return ans;
    }
    
    
    private ListNode getCycle(ListNode head){
        ListNode slow =head;
        ListNode fast =head;
         
        while(fast.next!=null&&fast.next.next!=null  && slow.next!=null){
            
            fast=fast.next.next;
            slow=slow.next;
            
            if(fast==slow){
                slow=head;
                while(fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }


    public void deleteDuplicate(){
        this.head=deleteDuplicates(this.head);
    }


    private ListNode deleteDuplicates(ListNode head) {
        
        if(head==null)  return null;
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        ListNode curr = head.next;
        int lastpopped =0;
        while(curr!=null){
            if(stack.isEmpty()&&curr.val!=lastpopped){
                stack.push(curr);
            }
            else if(!stack.isEmpty()&&curr.val!=stack.peek().val){
                if(curr.val!=lastpopped){
                stack.peek().next =curr;
                stack.push(curr);
                }
            }else if(!stack.isEmpty()){
              lastpopped= stack.peek().val;
              stack.pop();               
              if(!stack.isEmpty()) stack.peek().next =null;
                
            }
            curr=curr.next;
        }
        
        
        if(stack.isEmpty()) return null;
        
        while(stack.size()>1){
            stack.pop();
        }
        return stack.peek();
    }


    public void partitionList(int k){
        this.head=partition(this.head,k);
    }



    private ListNode partition(ListNode head, int x) {
        if(head==null)  return null;
        ListNode prev =null;
        ListNode rep = null;

        boolean repset =false;
        
        ListNode curr =head;
        while(curr!=null){
            if(curr.val<x){
                
                    //break the node 
                   if(prev!=null) prev.next = curr.next;
                    //join in middle
                    if(rep!=null){
                    curr.next = rep.next;
                    rep.next =curr;
                    }else{
                        if(curr!=head){
                        curr.next =head;
                        head=curr;
                        }
                    }
                rep=curr;
                
            }else{
                if(!repset){
                    repset=true;
                    rep=prev;
                }
            }
            prev =curr;
            curr =curr.next;
        }
        return head; 
    }


    public void reverseBetwn(int m ,int n){
        this.head= reverseBetween(this.head, m, n);
    }


    private ListNode reverseBetween(ListNode head, int m, int n) {
        
        ListNode start =  head;
        ListNode end   =  head;
        
        int tm =m;
        int tn =n;
        
        while(tm>2){
            tm--;
            start=start.next;
        }
        
        while(tn>0){
            tn--;
            end =end.next;
        }
        ListNode tosend = m==1?head:start.next;
        
        ListNode th = reverse(tosend,n-m,end);
        if(m!=1) start.next =th;
        else head=th;
                
        return head;
    }
    
    
    private ListNode reverse(ListNode head,int k,ListNode end){
        ListNode prev =head;
        ListNode curr = head.next;
        ListNode currnew;
        
        head.next= end;
        
        while(k>0){
            k--;
            currnew =curr.next;
            curr.next =prev;
            prev =curr;
            curr=currnew;
        }
        return prev;
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { 
         this.val = x;
        }
    }
    private static void displayTree(TreeNode node){
        if(node==null)return;
        StringBuilder str =new StringBuilder();
        if(node.left==null) str.append("Null");
        else str.append(node.left.val);
        str.append("=>");
        str.append(node.val+"<=");
        if(node.right==null)str.append("Null");
        else str.append(node.right.val);
    
        System.out.println(str);
        
        displayTree(node.left);
        displayTree(node.right);
        
    }

     
       
    public void printTree(){
        TreeNode root = getTreeFromLinkedList(this.head);
        displayTree(root);
    }
    private ListNode[] middleNode(ListNode head) {
        
        ListNode fast =head;
        ListNode slow =head;
        ListNode slowPrev = null;
            
        while(fast.next!=null&&fast.next.next!=null&&slow.next!=null){
            fast=fast.next.next;
            slowPrev = slow;
            slow=slow.next;
            
        }
        return  new ListNode[]{slow,slowPrev};
    }

    private TreeNode getTreeFromLinkedList(ListNode head){
        if(head==null) return null;
        
        ListNode[] midArray= middleNode(head);
        
        ListNode mid     = midArray[0];
        ListNode midPrev = midArray[1];
    
        TreeNode node = new TreeNode(mid.val);
        if(midPrev==null){
            node.left =null;
        }
        else{
            midPrev.next=null;
            node.left= getTreeFromLinkedList(head);
        }
        
        node.right = getTreeFromLinkedList(mid.next);
        return node;

    }


    public void sortList(){
        this.head=insertionSortList(this.head);
    }


    private ListNode insertionSortList(ListNode head) {
        
        if(head==null|| head.next==null) return head;
        ListNode itr = head.next;
        ListNode ansHead=head;
        head.next=null;
        ListNode newCurr =null;
        while(itr!=null){
            newCurr=itr.next;
            ansHead = insertNodeinSortedList(ansHead,itr);
            itr=newCurr;
        }
        return ansHead;
    }
    //add val in sortedlist and return its head
    private ListNode insertNodeinSortedList(ListNode head ,ListNode node){
        
        node.next=null;
        if(node.val<=head.val){
            node.next=head;
            return node;
        }  
       
        ListNode itr = head;
        boolean done =false;
        
        while(!done){
            if(itr.next==null){
                itr.next=node;
                done=true;
            }
            if(node.val>=itr.val&&node.val<itr.next.val){
                node.next =itr.next;
                itr.next=node;
                done =true;
            }
            itr=itr.next;
        }
        
        return head;
    }

    private void displayNode(ListNode head){
        ListNode curr=head;
        while(curr!=null){
            System.out.print(curr);
            curr=curr.next;
        }
        System.out.print("NULL");
        System.out.println();
     }

    public void printSpliitedLists(int k){
        for(ListNode node:splitListToParts(this.head, k)){
           displayNode(node);
        }
    }

    private int getSize(ListNode head){
        ListNode ptr = head;
        int size=0;
        
        while(ptr!=null){
            size++;
            ptr=ptr.next;
        }
        return size;
    }

    private ListNode[] splitListToParts(ListNode head, int k) {
        
        int size = getSize(head);
        ListNode [] ans = new ListNode[k];
        ListNode nextPtr=null;
        ListNode ptr=null;
        
        if(size>k){
            int x = size/k;
            int y =  size%k;
            int fs =0;
            
            int rs=0;
            int left = 0;

            if(y==0){
                fs=x;
                rs=x;
            }
            
            else if(y==1){
              fs = x+y;
              rs=x;
            }else{
                fs=y;
                rs=y;
            }
            
            left=size-fs;
            
            ptr = head;
            while(fs>1){
                fs--;
                ptr=ptr.next;
            }
            nextPtr = ptr.next;
            ptr.next=null;
            ans[0]=head;
            
            
            
            head = nextPtr;
            ListNode itr = nextPtr;
            int idx =1;
            while(left>0){
                int count = 0;
                if(y==1) count =rs;
                else {
                    if(idx==k-1) count = x;
                    else count = rs;  
                }
                left =left-count;
                while(count>1){
                    itr=itr.next;
                    count--;
                }
                nextPtr = itr.next;
                itr.next=null;
                ans[idx]=head;
                head = nextPtr;
                itr = nextPtr;
                idx++;
            }  
            
            
        }else{
           ptr = head;
           int idx =0;
           while(size>0){
               size--;
               nextPtr = ptr.next;
               ptr.next=null;
               ans[idx]=ptr;
               ptr = nextPtr;
               idx++;
           }
        }
        
        return ans;
        
       
    }

    public void removeConsecutiveZero(){
        this.head = removeZeroSumSublists(this.head);
    }

    private ListNode removeZeroSumSublists(ListNode head) {
        if(head==null )  return head;
        if(head.next==null){
            if(head.val==0)  return null;
            return head;
        }
        
        Stack<ListNode> stack = new Stack<>();
        ListNode curr= head;
        ListNode inner = null;
        ListNode rmv =null;
        int sum =0;
        int flag =0;
        while(curr!=null){
            sum =0;
            flag =0;
            inner = curr;
            while(inner!=null){
                sum += inner.val;
                if(sum==0){
                    flag =1;
                    if(!stack.isEmpty()) {
                        rmv =stack.pop();
                        rmv.next =inner.next;
                        curr=rmv;
                    }else{
                        curr=inner.next;
                        head=curr;
                    }
                    break;
                    
                }
                inner=inner.next;
            }
            if(flag==0){
            stack.push(curr);
            curr=curr.next;
            }
        } 
        return head;
    }
}