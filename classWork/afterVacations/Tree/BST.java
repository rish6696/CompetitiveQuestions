import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BST {

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val ;
        private TreeNode(int val){
            this.val=val;
        }

    }

   private TreeNode root;
   private int [] preOrder=null;
   private int idx =0;

   public static TreeNode rightMostToLeft(TreeNode left ,TreeNode curr ){
       while(left.right!=null && left.right!=curr){
           left=left.right;
       }

       return left;

   }

   public void morrisTraversal(){
       TreeNode curr = this.root;
       TreeNode nextLeft =null;
       while(curr!=null){
           nextLeft=curr.left;
           if(nextLeft==null){
               System.out.print(curr.val+" ");
               curr=curr.right;
           }else{
               TreeNode rightTOleft =rightMostToLeft(nextLeft, curr);
               if(rightTOleft.right==null){
                  
                    rightTOleft.right=curr; // create a thread 
                    curr=curr.left;
               }else{
                   System.out.print(curr.val+" ");
                   rightTOleft.right=null; //break the thread 
                   curr=curr.right;
               }
           }
       }

   }

   public int maxRightVal(TreeNode node){
       while(node.right!=null){
           node=node.right;
       }
       return node.val;
   }


//    public TreeNode removeNode(TreeNode node,int data){
//        if(node==null) return null;
//        if(node.val==data ){
//            if(node.left==null||node.right==null){
//                return node.left==null ? node.right:node.left;
//            }
//            int max=maxRightVal(node.left);
//            node.val=max;
//            node.left=removeNode(node.left, max);
//            //handle case for node with both children 
//        }else if(node.val<data){
//            node.right =removeNode(node.right, data);
//        }else{
//            node.left=removeNode(node.left, data);
//        }
//        return node;
//    }
   

   public BST(int[]preOrder) {
      this.preOrder=preOrder;
      this.idx=0;
      root=createTree(0,preOrder.length-1);

   }

   public BST(){
       this.root =null;
   }


   public void addNode(int data){
    if(this.root==null){
        TreeNode root=new TreeNode(data);
        this.root=root;
    }else{
        this.root=addRecursion(this.root, data);
    }
    
 }

 private TreeNode addRecursion(TreeNode node,int data){
    if(node==null){
      TreeNode newNode =new TreeNode(data);
      return newNode; 
    }
    if(node.val< data){
      node.right =addRecursion(node.right, data);
    }
    if(node.val>data){
        node.left=addRecursion(node.left, data);
    }

 
    return node;

 }


   public void succesorPrecessor(int data){
       TreeNode succesor =null;
       TreeNode predessor =null;
       TreeNode node =this.root;
       while(node!=null){
           if(node.val==data){
               if(node.right!=null){
                   succesor=node.right;
                   while(succesor.left!=null){
                       succesor=succesor.left;
                   }
               }

            if(node.left!=null){
                predessor=node.left;
                while(predessor.right!=null){
                    predessor=node.right;
                }
            }
            break;
           }else if(node.val < data ){
              // goid to right
              predessor=node;
              node=node.right; 
              
           }else{
               //going to left 
               succesor=node;
               node=node.left;

           }
       }

       int succ = succesor==null?-1:succesor.val;
       int pre= predessor==null?-1:predessor.val;
       System.out.println("Successor: "+succ);
       System.out.println("Predecessor: "+pre);

   }

   public void inOrderPrint(){
        inOrderPrint(this.root);
        System.out.println();
   }
   private void inOrderPrint(TreeNode node){
       if(node==null)return ;
       inOrderPrint(node.left);
       System.out.print(node.val+" ");
       inOrderPrint(node.right);
   }

  

   public TreeNode createTree(int si,int ei){
       if( si >ei ){
        return null;
       }
       int mid =(si+ei)/2;
       TreeNode node =new TreeNode(preOrder[mid]);
       node.left=createTree(si, mid-1);
       node.right=createTree(mid+1, ei);
       return node;

    }

public void display(){
    display(this.root);
}


private static void display(TreeNode node){
    if(node==null)return;
    StringBuilder str =new StringBuilder();
    if(node.left==null) str.append("Null");
    else str.append(node.left.val);
    str.append("=>");
    str.append(node.val+"<=");
    if(node.right==null)str.append("Null");
    else str.append(node.right.val);

    System.out.println(str);
    
    display(node.left);
    display(node.right);
    
}



// _101Symmetric

public boolean isSymmetric(TreeNode root) {
    return symetric(root,root);
    
}

private boolean symetric(TreeNode lefttree,TreeNode rightree){
    if(lefttree==null&&rightree==null)return true;
    if(lefttree==null||rightree==null) return false;
     return lefttree.val == rightree.val && symetric(lefttree.left,rightree.right) && symetric(lefttree.right,rightree.left);
    
}



public List<List<Integer>> levelOrder(){

    List<List < Integer>> big =new ArrayList<>();
    LinkedList<TreeNode> queue =new LinkedList<>();
    int level =0;
    queue.addLast(this.root);
    List<Integer> a=new ArrayList<>();
    while(!queue.isEmpty()){
        int size =queue.size();
        while(size>0){
            size--;
            TreeNode node=queue.removeFirst();
            a.add(node.val);
            if(node.left!=null)queue.addLast(node.left);
            if(node.right!=null)queue.addLast(node.right);

        }
        level++;
        big.add(a);
        a=new ArrayList<>();
       
    }
    return big;

}

public static int height(TreeNode node){
   if(node==null)return -1;
   int l =height(node.left);
   int r =height(node.right);
   return Math.max(l, r) +1;
}


public List<List<Integer>> zigZagLevelOrder() {

    List<List < Integer>> big =new ArrayList<>();
    int hieght = height(this.root);
    int dir =0;
    for (int i = 0; i <= hieght; i++) {
        List<Integer> a=new ArrayList<>();
        goTOlevel(0, i, a, dir, root);
        big.add(a);
        a=new ArrayList<>();
        dir=(dir+1)%2;
    }
    return big;


    // Stack<TreeNode> stack =new Stack<>();
    // int level =0;
    // stack.push(this.root);
    // int dir =0;  //0 for left to right and 1 for right to left
    // List<Integer> a=new ArrayList<>();
    // while(!stack.isEmpty()){
    //     int size =stack.size();
    //     while(size>0){
    //         size--;
    //         TreeNode node=stack.pop();
    //         a.add(node.val);
    //         if(dir==0){
    //            if(node.left!=null) stack.push(node.left);
    //            if(node.right!=null) stack.push(node.right);
    //         }else{
    //             if(node.right!=null) stack.push(node.right);
    //             if(node.left!=null) stack.push(node.left);
    //         }

    //     }
    //     level++;
    //     dir =(dir+1)%2;
    //     big.add(a);
    //     a=new ArrayList<>();
       
    // }
    // return big;

}


public void goTOlevel(int cl,int fl,List<Integer> ans,int dir,TreeNode node){
    if(node==null)return;
    if(cl==fl){
        ans.add(node.val);
        return ;
    }
    if(dir ==0){
        goTOlevel(cl+1, fl, ans, dir, node.left);
        goTOlevel(cl+1, fl, ans, dir, node.right);
    }else{
        goTOlevel(cl+1, fl, ans, dir, node.right);
        goTOlevel(cl+1, fl, ans, dir, node.left);
    }
}

public List<Integer> rightView(){
    List<Integer> ans =new ArrayList<>();
    LinkedList<TreeNode> queue=new LinkedList<>();
    queue.add(this.root);
    int level =0;
    while(!queue.isEmpty()){
        TreeNode lastAdded =queue.getLast();
        ans.add(lastAdded.val);
        int size =queue.size();
        while(size > 0){
            size--;
            TreeNode rmNode=queue.removeFirst();
            if(rmNode.left!=null) queue.add(rmNode.left);
            if(rmNode.right!=null)queue.add(rmNode.right);

        }
        level++;
    }
    return ans;

}

//using arraylist as a queue 
public void reverseLevelPrint(){
    ArrayList<TreeNode> list =new ArrayList<>();
    list.add(root);
    int idx =1;
    int remover =0;
    int level =0;
    while(remover<idx){
        int size =idx-remover;
        while(size >0 ){
            size--;
            TreeNode rmtx =list.get(remover);
            remover++;
            if(rmtx.left!=null){
               list.add(rmtx.left);
              idx++;
            }
            if(rmtx.right!=null){
                list.add(rmtx.right);
                idx++;
            }
        }
        level++;

    }

    for (int i = 0; i < list.size(); i++) {
        System.out.print(list.get(i).val+" ");
    }

}

public List <List<Integer>> pathSumList(int sum){
    List<Integer> ans =new ArrayList<>();
    List <List<Integer>>bigAns=new ArrayList<>();
    pathSum(this.root, 0, sum, ans, bigAns);
    return bigAns;
    
}


public void pathSum(TreeNode node,int csum ,int fsum, List<Integer> ans,List <List<Integer>>bigAns){
    csum+=node.val;
    if( node.left==null && node.right==null && csum ==fsum){ 
        ans.add(node.val);
        List<Integer> base =new ArrayList<>();
        base.addAll(ans);
        ans.remove(ans.size()-1);
        bigAns.add(base);
        return ;
    }
    if(node.left!=null ){
        ans.add(node.val);
        pathSum(node.left, csum,fsum, ans, bigAns);
        ans.remove(ans.size()-1);
    }

    if(node.right!=null){
        ans.add(node.val);
        pathSum(node.right, csum,fsum, ans, bigAns);
        ans.remove(ans.size()-1);
    }
}



//124. Binary Tree Maximum Path Sum


public int maxSum(){
    int []a =new int [1];
    a[0]=Integer.MIN_VALUE;
    maxSumRecursion(this.root,a);
    return a[0];
}


private int maxSumRecursion(TreeNode node,int []a){
    if(node==null)return 0;

    int  left=maxSumRecursion(node.left,a);
    int  right =maxSumRecursion(node.right,a);

    int maxbranch= Math.max(left, right);
    a[0]=Math.max ( Math.max(a[0], node.val) ,  Math.max(maxbranch+node.val,node.val+left+right));
    return Math.max(node.val, node.val+maxbranch);


}


public int[] diameter(TreeNode node){
    if(node ==null){
        return new int []{ 0,-1 };
    }
    int [] l=diameter(node.left);
    int [] r =diameter(node.right);
    int [] ans =new int [2];
    ans[0]=Math.max(Math.max(l[0], r[0]), l[1]+r[1]+2);
    ans[1]=Math.max(l[0], r[0])+1;
    return ans ;
} 


public int minCameras(){
    int [] a=new int [1];
    int ans =cameraRecursion(root, a);
    if(ans ==-1) a[0]++;
    return a[0];
}

private int  cameraRecursion(TreeNode node,int []a){
    if(node==null) return 0;
    int left  = cameraRecursion(node.left,a);
    int right = cameraRecursion(node.right,a);

    if(left==-1||right==-1){
       a[0]++;
       return 1;
    }

    if(left==1||right ==1){
        return 0;
    }
    return -1;
}




public void recoverTree() {
    TreeNode first =null;
    TreeNode sec   =null;
    TreeNode third =null;
    TreeNode [] mem= new TreeNode[3];
    inorder(root,mem,null);
    mem[0]=first;
    mem[1]=sec;
    mem[2]=third;
    if(mem[2]==null){
        int v =mem[0].val;
        mem[0].val =mem[1].val;
        mem[1].val =v;
    }else{
        int v =mem[0].val;
        mem[0].val =mem[2].val;
        mem[2].val =v;
    }      
 }

 private void inorder(TreeNode node, TreeNode []mem,TreeNode prev){
     if(node==null)return;
     inorder(node.left,mem,prev);
     if(prev !=null){
         if(node.val<prev.val){
             if(mem[0]==null&& mem[1] ==null){
                mem[0] =prev;
                mem[1]=node;
             }else{
                mem[2] =node;
             }
         }
     }
     prev =node;
     inorder(node.right,mem,prev);
     
 }


public void widthTree(TreeNode node){
    int [] width =new int []{Integer.MAX_VALUE,Integer.MIN_VALUE};
    calWidth(root, width, 0);

} 

private void calWidth(TreeNode node,int[]width,int curr){
    if(node ==null)return;
    width[0]=Math.min(width[0],curr);
    width[1]=Math.max(width[1], curr);
    calWidth(node.left, width, curr-1);
    calWidth(node.right, width, curr+1);
}






public void trimBST(int L, int R) {
        
    List<Integer>a =new ArrayList<>();
    getList(root,a,L,R);
    TreeNode node =root;
    for(int i=0;i<a.size();i++){
         node =removeNode(node,a.get(i),L,R);
    }
    display(node);
    
}



public void getList(TreeNode node,List<Integer>a,int left,int right){
    if(node==null) return ;
    if(node.val<left && node.val < right || node.val >left&& node.val> right){
        a.add(node.val);
    }
    getList(node.left,a,left,right);
    getList(node.right,a,left,right);
}




public int maxleft(TreeNode left){
    while(left.right!=null){
        left =left.right;
    }
    return left.val;
}

public int minRight(TreeNode right){
    while(right.left!=null){
        right =right.left;
    }
    return right.val;
}

public TreeNode removeNode(TreeNode node,int data,int l,int r){
    if(node.val==data){
        if(node.left==null || node.right ==null){
        return node.left ==null ?node.right:node.left;
        }
        int lmax =maxleft(node.left);
        if(lmax>=l && lmax <=r){
            lmax=minRight(node.right);
            node.val=lmax;
            node.right =removeNode(node.right ,lmax,l,r);
        }else{
            node.val=lmax;
            node.left =removeNode(node.left ,lmax,l,r);
        }
         
    }
    else if(node.val< data){
        node.right =removeNode(node.right,data,l,r);
    }else{
        node.left =removeNode(node.left,data,l,r);
    }
    return node;
}


public void increasingBST() {
    TreeNode [] ans =new TreeNode[]{null,null};
    createTree(root,ans);
    display(ans[0]);
}


public void createTree(TreeNode node,TreeNode[]parent){
    if(node==null) return ;
    createTree(node.left,parent);
    if(parent [0]==null){
        parent[0]=node;
        parent[1]=node;
    }else{
        TreeNode a =new TreeNode(node.val);
        parent[1].right =a;
        parent[1]=a;  
    }
    createTree(node.right,parent);
}





public int rangeSum(int l ,int r){
  return rangeSumBST(root, l, r);
}
private  int rangeSumBST(TreeNode root, int L, int R) {
    if(root ==null) return 0;
    
    int sum =0;
    if(root.val >=L && root.val <= R){
        sum +=root.val;
    }
    int left =0;
    int right =0;
    if(root.val<R) right  =rangeSumBST(root.right,L,R);
    if(root.val > L) left =rangeSumBST(root.left,L,R);
    
    return sum +left+right;
}

}