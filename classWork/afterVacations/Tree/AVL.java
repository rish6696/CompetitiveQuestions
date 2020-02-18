import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;
import java.util.Comparator;

public class AVL {

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        int balance = 0;
        int height =-1;

        private TreeNode(int val){
            this.val=val;
        }

    }

   private TreeNode root;
   


   public TreeNode llRotate(TreeNode node){
       TreeNode y =node.left;
       TreeNode b =y.right;
       y.right =node;
       node.left =b;

       updateHeightAndUpdate(node);
       updateHeightAndUpdate(y);

       return  y;
   }


   public TreeNode rrRotate(TreeNode node){
    TreeNode y =node.right;
    TreeNode b =y.left;
    y.left =node;
    node.right =b;


    updateHeightAndUpdate(node);
    updateHeightAndUpdate(y);
    return  y;
 }

 public void updateHeightAndUpdate(TreeNode node){
   if(node ==null)return;
   int lh =-1;
   int rh =-1;

   if(node.left!=null) lh =node.left.height;
   if(node.right!=null) rh =node.right.height;
   node.height=Math.max(lh, rh)+1;
   node.balance=lh-rh;

 }

 public  TreeNode rotate(TreeNode node){
    updateHeightAndUpdate(node);
    int bf =node.balance;
    if(bf==2){
        //means ll or lr rotation
        if(node.left.balance==1){
            //means it is ll rotation
            node =llRotate(node);
            return node;
        }else{
            // it is lr rotation
            TreeNode n = rrRotate(node.left);
            node.left=n;
            node=llRotate(node);
        }
    }else if(bf ==-2){
        if(node.right.balance==-1){
            //means it is rr rotation
            node =rrRotate(node);
            return node;
        }else{
            // it is rl rotation
            TreeNode n = llRotate(node.right);
            node.right=n;
            node=rrRotate(node);
        }

    }
    return node;

 }





   public static TreeNode rightMostToLeft(TreeNode left ,TreeNode curr ){
       while(left.right!=null && left.right!=curr){
           left=left.right;
       }

       return left;

   }



   public int maxRightVal(TreeNode node){
       while(node.right!=null){
           node=node.right;
       }
       return node.val;
   }


   public void removeNode(int data){
       if(root==null) return ;
       this.root= removeNode(root, data);
   }


   private TreeNode removeNode(TreeNode node,int data){
       if(node==null) return null;
       if(node.val==data ){
           if(node.left==null||node.right==null){
               return node.left==null ? node.right:node.left;
           }
           int max=maxRightVal(node.left);
           node.val=max;
           node.left=removeNode(node.left, max);
           //handle case for node with both children 
       }else if(node.val<data){
           node.right =removeNode(node.right, data);
       }else{
           node.left=removeNode(node.left, data);
       }

       node=rotate(node);
       return node;
   }
   

   public AVL(){
     this.root=null;
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

      node=rotate(node);
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

public class VerticalPair{
    int level=0;
    TreeNode node ;
    public VerticalPair(int level ,TreeNode node){
      this.level=level;
      this.node=node;
    }
}

public List< List<Integer> > verticalView(){
    int [] width =widthTree();
    int size = -width[0]+width[1]+1;
    ArrayList<Integer> [] container =new ArrayList [size];
    for (int i = 0; i < container.length; i++) {
        container[i]=new ArrayList<>();
    }
    LinkedList<VerticalPair> queue=new LinkedList<>();
    queue.add(new VerticalPair(-width[0], root));
    ArrayList<VerticalPair> levelList =new ArrayList<>();
    
    while(!queue.isEmpty()){
        int s =queue.size();
        while(s>0){
            s--;

            VerticalPair p =queue.removeFirst();
            levelList.add(p);
            TreeNode rmNode =p.node;
            int level =p.level;
            if(rmNode.left!=null){
               queue.add(new VerticalPair(level-1, rmNode.left));
            }

            if(rmNode.right!=null){
                queue.add(new VerticalPair(level+1, rmNode.right));
            }
        }
        Collections.sort(levelList,new Comparator<VerticalPair>() {
            @Override
            public int compare(VerticalPair arg0, VerticalPair arg1) {
            
                return arg0.node.val-arg1.node.val;
            }
        });

        for (int i = 0; i < levelList.size(); i++) {
            VerticalPair v =levelList.get(i);
            container[v.level].add(v.node.val);
        }

        levelList.clear();
    }

    List < List<Integer> > ans =new ArrayList<>();
    for (int i = 0; i < container.length; i++) {
        ans.add(container[i]);
    }
    return ans;

}




public int [] widthTree(){
    int [] width =new int []{Integer.MAX_VALUE,Integer.MIN_VALUE};
    calWidth(root, width, 0);
    return width;

} 

private void calWidth(TreeNode node,int[]width,int curr){
    if(node ==null)return;
    width[0]=Math.min(width[0],curr);
    width[1]=Math.max(width[1], curr);
    calWidth(node.left, width, curr-1);
    calWidth(node.right, width, curr+1);
}

}