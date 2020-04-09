import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Tree{

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

   public Tree(){
       
   }

   public Tree(int[]preOrder){
      this.preOrder=preOrder;
      this.idx=0;
      root=createTree();

   }

   public TreeNode createTree(){
    if( idx >=this.preOrder.length||this.preOrder[idx]==-1 ){
        idx++;
        return null;
    }
    TreeNode node =new TreeNode(preOrder[idx]);
    idx++;
    node.left=createTree();
    node.right=createTree();
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





public void buildTreePree(int[] preorder, int[] inorder) {
        
    Map<Integer,Integer> mapper =new HashMap<>();
    for(int i=0;i<inorder.length;i++){
        mapper.put(inorder[i],i);
    }
    
    int [] idx =new int [1];
    TreeNode n=createPre(0,preorder.length-1,preorder,inorder,idx,mapper);
    display(n);
    
}


private TreeNode createPre(int start ,int end,int [] preorder,int [] inorder,int []idx,Map<Integer,Integer> mapper){
  
    if(start> end )return null;
    int val =preorder[idx[0]];
    TreeNode node =new TreeNode(preorder[idx[0]]);
    idx[0]++;
    if(start==end)return node;
    
    int inidx =mapper.get(val);
    node.left =createPre(start,inidx-1,preorder,inorder,idx,mapper);
    node.right =createPre(inidx+1,end,preorder,inorder,idx,mapper);
    return node;
}







public void buildTreePost(int[] preorder, int[] inorder) {
        
    Map<Integer,Integer> mapper =new HashMap<>();
    for(int i=0;i<inorder.length;i++){
        mapper.put(inorder[i],i);
    }
    
    int [] idx =new int [1];
    idx[0]=preorder.length-1;
    TreeNode n=createPost(0,preorder.length-1,preorder,inorder,idx,mapper);
    display(n);
    
}


private TreeNode createPost(int start ,int end,int [] preorder,int [] inorder,int []idx,Map<Integer,Integer> mapper){
  
    if(start> end||start<0 ||end>preorder.length-1 || idx[0]<0)return null;
    System.out.println(idx[0]);
      
    int val =preorder[idx[0]];
    TreeNode node =new TreeNode(preorder[idx[0]]);
    idx[0]--;
    if(start==end)return node;
    
    int inidx =mapper.get(val);
    node.right =createPost(inidx+1,end,preorder,inorder,idx,mapper);    
    node.left =createPost(start,inidx-1,preorder,inorder,idx,mapper);
        
    return node;
}


public void recoverTree() {
   
    TreeNode [] mem= new TreeNode[4];
    inorder(this.root,mem);
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

 private void inorder(TreeNode node, TreeNode []mem){
     if(node==null)return;
     inorder(node.left,mem);
     if(mem[3] !=null){
         if(node.val<mem[3].val){
             if(mem[0]==null&& mem[1] ==null){
                mem[0] =mem[3];
                mem[1]=node;
             }else{
                mem[2] =node;
             }
         }
     }
     mem[3] =node;
     inorder(node.right,mem);
     
 }





 public int[] findMode() {
    if(root ==null) return new int[]{};
    List<Integer> mode =new ArrayList<>();
    int []variables =new int[]{1,Integer.MIN_VALUE};
    TreeNode [] prev =new TreeNode[]{null};
    inOrder(root,prev,mode,variables);
    
    
       if(variables[0]>variables[1]){
                mode.clear();
                mode.add(prev[0].val);
                variables[1]=variables[0];
            }else if(variables[0]==variables[1]){
               mode.add(prev[0].val);
            }
    
    

    int [] array =new int [mode.size()];
    for(int i=0;i<array.length;i++){
        array[i]=mode.get(i);
    }
    return array;

    
}

public void inOrder(TreeNode root,TreeNode[] prev, List<Integer> mode,int []variables ){
    if(root==null)return;
     inOrder(root.left,prev,mode,variables);
     if(prev[0]!=null){
        if(prev[0].val==root.val){
            variables[0]++;
        }
    else{
             if(variables[0]>variables[1]){
                mode.clear();
                mode.add(prev[0].val);
                variables[1]=variables[0];
            }else if(variables[0]==variables[1]){
               mode.add(prev[0].val);
            }
            variables[0]=1;
        }
     }
    prev[0]=root;
     
    inOrder(root.right,prev,mode,variables);
}



public void printTree() {
    int h =height(root)+1;
    int col =(int)Math.pow(2,h)-1;
    String [][] arr =new String [h][col];
    
    
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            arr[i][j]="";
        }
    }



    
    
    insert(root,0,0,col-1,arr);

    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
    
    // List< List<String> >  ans =new ArrayList<>();
    
    // for(int i=0;i<arr.length;i++){
    //    ans.add(Arrays.asList(arr[i]));
    // }
    
    
   // return ans ;
      
}


public void insert(TreeNode node,int row,int cStart,int cEnd,String [][]arr){
    if(node ==null)return ;
    
    int mid =(cStart+cEnd)/2;
    arr[row][mid]=node.val+"";
    insert(node.left,row+1,cStart,mid-1,arr);
    insert(node.right,row+1,mid+1,cEnd,arr);
}





public void subtreeWithAllDeepest() {

    TreeNode[] ans =new TreeNode[]{null};
    int h =height(root);
    int [] c=new int []{0};
    
    counAtlast(root,0,h,c,ans);
    if(c[0]==1){
        display(ans[0]);
        return ;
    }
    sol(root,ans,h,0);
    display(ans[0]);
}



public void counAtlast(TreeNode node,int curr,int fi,int []c,TreeNode[]ans ){
    if(node==null)return ;
    if(curr==fi){
        ans[0]=node;
        c[0]++;
    }
    counAtlast(node.left,curr+1,fi,c,ans);
    counAtlast(node.right,curr+1,fi,c,ans);
    
}



public boolean sol(TreeNode node,TreeNode []ans ,int f,int c){
    if(node.left==null && node.right ==null){
    return f == c ? true:false;
}
boolean l =false;
boolean r =false;
if(node.left!=null) l =sol(node.left,ans,f,c+1);
if(node.right!=null) r =sol(node.right,ans,f,c+1);
if(l && r) ans[0]=node;

return l || r;
    
}


public TreeNode getTree(int[] pre,int []post,int []preI,int []posI){
    if( preI[0] >=pre.length -1 || posI[0]>=post.length -1||  pre[preI[0]]==post[posI[0]]){
        int val =pre[preI[0]];
        TreeNode node =new TreeNode(val);
        preI[0]++;
        posI[0]++;
        return node;
    }
    
    int val =pre[preI[0]];
    preI[0]++;
    
    TreeNode node =new TreeNode(val);
    node.left =getTree(pre,post,preI,posI);
    node.right = getTree(pre,post,preI,posI);
    
    posI[0]++;
    return node;
    
}

public void constructFromPrePost(int[] pre, int[] post) {
    int []preI=new int []{0};
    int []posI=new int []{0};
    display(getTree(pre,post,preI,posI));
    
}



 Map<Integer, List<TreeNode>> memo = new HashMap<>();

 public void possibleBST(int n){
    HashMap<Integer,List<TreeNode>> cache=new HashMap<>();
    for(TreeNode node: possibleNodes(n,cache) ){
        display(node);
        System.out.println("***************************************");
    }
 }

    // public List<TreeNode> allPossibleFBT(int N) {
    //     if (!memo.containsKey(N)) {
    //         List<TreeNode> ans = new LinkedList<>();
    //         if (N == 1) {
    //             ans.add(new TreeNode(0));
    //         } else if (N % 2 == 1) {
    //             for (int x = 0; x < N; ++x) {
    //                 int y = N - 1 - x;
    //                 for (TreeNode left: allPossibleFBT(x))
    //                     for (TreeNode right: allPossibleFBT(y)) {
    //                         TreeNode bns = new TreeNode(0);
    //                         bns.left = left;
    //                         bns.right = right;
    //                         ans.add(bns);
    //                     }
    //             }
    //         }
    //         memo.put(N, ans);
    //     }

    //     return memo.get(N);
    // }

    public List<TreeNode> possibleNodes(int n,HashMap<Integer,List<TreeNode>> cache ) {
    
      if(cache.containsKey(n)){
        return cache.get(n);
      }
      List<TreeNode> ans =new ArrayList<>();
      if(n==1){
          TreeNode node =new TreeNode(0);
          ans.add(node);
          return ans;
      }

      int i =1;
      while(i<n){
        int l =i;
        int r =n-i-1;
        List<TreeNode> left =possibleNodes(l,cache);
        List<TreeNode> right =possibleNodes(r,cache);
        i+=2;
        for(TreeNode a :left){
            for(TreeNode b:right){
                TreeNode c =new TreeNode(0);
                c.left=a;
                c.right=b;
                ans.add(c);
            }
        }


      }
      cache.put(n, ans);
      return ans ;
    }



    public boolean flipEquiv(Tree t) {
        TreeNode root1=this.root;
        TreeNode root2=t.root;
        if(root1.val!=root2.val)return false;
        return sol(root1,root2);    
    }
    
    
    public boolean sol(TreeNode a,TreeNode b) {
        if(a.left==null &&b.left==null && b.right==null && a.right ==null)return true;
        boolean left =false;
        boolean right =false;
        
        if(a.left!=null && b.left!=null &&a.left.val ==b.left.val) {
            left =sol(a.left,b.left);
        }
        if(a.left!=null && b.right!=null &&  a.left.val ==b.right.val){
            left =sol(a.left,b.right);
        }

        if(a.left==null){
            left = b.left==null || b.right==null;
        }
        
        if(a.right!=null && b.right!=null &&a.right.val == b.right.val){
            right =sol(a.right,b.right);
        }
        if(a.right!=null && b.left!=null &&a.right.val ==b.left.val){
            right =sol(a.right ,b.left);
        }

        if(a.right==null){
            right = b.left==null || b.right==null;
        }

        return left && right ;
    }

    class ANode {  // Annotated Node
        TreeNode node;
        int code;
        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
}


public boolean isCompleteTree() {
    List<ANode> nodes = new ArrayList<>();
    nodes.add(new ANode(root, 1));
    int i = 0;
    while (i < nodes.size()) {
        ANode anode = nodes.get(i++);
        if (anode.node != null) {
            nodes.add(new ANode(anode.node.left, anode.code * 2));
            nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
        }
    }

    return nodes.get(i-1).code == nodes.size();
}



public int maxAncestorDiff() {
    int [] ans =new int []{Integer.MIN_VALUE};
    sol(root,ans);
    return ans[0];
}



public int sol(TreeNode root ,int[] ans){
    if(root==null)return Integer.MAX_VALUE;
    if(root.left==null&&root.right==null)return root.val;
    
    int left =sol(root.left,ans);
    int right =sol(root.right,ans);
    
    int m =Math.min(left,right);
    
    ans[0]=Math.max(ans[0],root.val-m);
    return Math.min(m,root.val);
    
    
}





}