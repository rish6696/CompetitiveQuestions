import java.util.ArrayList;
import java.util.List;
public class Lect00_1{

    public static  class Node{
        Node left ;
        Node right ;
        int data;


        public Node(int data){
            this.left=null;
            this.right=null;
            this.data=data;

        }

        @Override
        public String toString() {
            String str="" ;

            if(this.left==null) str+="NULL";
            else str+=this.left.data;
            str+="=>";
            str+=this.data+"<=";
            if(this.right==null)str+="Null";
            else str+=this.right.data;

            str+="\n";
            if(this.left!=null) str +=this.left.toString();
            if(this.right!=null) str +=this.right.toString();

            return str;
    
            
        }


    }


    public static class pairSol{
        int pre=0;
        int suc=0;
    }


    public static void pairSolSolution(Node node,pairSol ans,int lastPrinted,int ques){
        if(node==null)return ;
        pairSolSolution(node.left, ans, lastPrinted,ques);
        if(ques==node.data){
           ans.pre=lastPrinted;
        }
        lastPrinted=node.data;
        pairSolSolution(node.right, ans, lastPrinted, ques);
    }

    static Node root=null ;
    static int idx=0;


    public static Node createTree(int [] preOrder){
        if(preOrder[idx]==-1){
            idx++;
            return null;
        }
        Node node =new Node(preOrder[idx]);
        idx++;
        node.left=createTree(preOrder);
        node.right=createTree(preOrder);
        return node;
        
    }
    public static void display(Node node){

        if(node==null)return;
        StringBuilder str =new StringBuilder();
        if(node.left==null) str.append("Null");
        else str.append(node.left.data);
        str.append("=>");
        str.append(node.data+"<=");
        if(node.right==null)str.append("Null");
        else str.append(node.right.data);


        System.out.println(str);
        
        display(node.left);
        display(node.right);
        

    }

    public static void main(String[] args) {
       // int [] preOrder ={10,20,40,-1,-1,-1,30,-1,-1};
       int [] preOrder ={ 10,20,40,80,-1,-1,90,-1,-1,50,-1,-1,30,60,-1,-1,70,130,-1,-1,140,-1,-1}; 
        //int [] preOrder ={};
        root =createTree(preOrder);
        display(root);
        System.out.println();
        printBoundary(root);
    }
    public static int height(Node node){
        if(node ==null) return -1;
        int left =height(node.left);
        int right= height(node.right);
        return Math.max(left, right)+1;
    }

    public static int size(Node node){
        if(node ==null) return 0;
        int left =size(node.left);
        int right= size(node.right);
        return left+right+1;
    }

    public static Node findNode(Node node,int data){
  
        if(node==null)return null;
        if(node.data==data)return node;
        Node left =findNode(node.left,data);
        if(left!=null)return left;
        Node right =findNode(node.right,data);
        if(right!=null)return right;
        return null;
        

    }

    public static boolean find(int data,Node node){
        if(node==null)return false;
        if(node.data==data)return true;
        boolean left =find(data, node.left);
        if(left)return true;
        boolean right =find(data, node.right);
        if(right)return true;
        return false;
    }


    public static int lowestCommonAncestor(int a,int b){
        ArrayList<Node> pathA=rootTOleafPath(a);
        ArrayList<Node> pathB =rootTOleafPath(b);
        int i =pathA.size()-1;
        int j =pathB.size()-1;
        while(i>=0 && j >=0 ){
            if(pathA.get(i)!=pathB.get(j)){
                if(i==pathA.size()-1 && j==pathB.size()-1 ){
                    return -1;
                }
                else{
                    return  pathA.get(i-1).data;
                }
            }
            i--;
            j--;
        }
        return pathA.get(i+1).data;
    }




    public static ArrayList <Node> rootTOleafPath(int data){
        ArrayList<Node> path=new ArrayList<>();
        rootLeaf(data, root, path);
        return path;
    }

    public static boolean rootLeaf(int data,Node node,  ArrayList<Node> path){
        if(node==null)return false;
        if(node.data==data){
            path.add(node);
            return true;
        }
        boolean left =rootLeaf(data, node.left,path);
        if(left){
            path.add(node);
            return true;
        }
        boolean right =rootLeaf(data, node.right,path);
        if(right){
            path.add(node);
            return true;
        }
        return false;

    }


    public static int min(Node node){
        return node ==null ? Integer.MAX_VALUE: Math.min( node.data, Math.min( min (node.left),min(node.right)));
        // if(node ==null) return Integer.MAX_VALUE;
        // return Math.min( node.data, Math.min( min (node.left),min(node.right)));
    }

    public static void kNiebours_01(Node node ,int k){
        ArrayList<Node> path =rootTOleafPath(node.data);
        Node pNode =null;
        for (int i = 0; i < path.size(); i++) {
            kDown(path.get(i), pNode, k-i);
            pNode=path.get(i);   
        }
    }

    public static List<Integer> kniebours_02(Node node,int k){
        List<Integer> ans =new ArrayList<>();
       findNodeKniebour(root, ans, node.data, k);
       return ans;
    }

    public static int  findNodeKniebour(Node node,List<Integer> ans,int data,int k){
        if(node==null)return -1;
        if(node.data==data){
            kDown(node, null, k);
            return 1;
        }
        int lf =findNodeKniebour(node.left, ans, data, k);
        if(lf!=-1){
            kDown(node, node.left, k-lf);
            return lf+1;
        }
        int rf =findNodeKniebour(node.right, ans, data, k);
        if(rf!=-1){
            kDown(node, node.right, k-rf);
            return rf+1;
        }
        return -1;

    }



    public static void kDown(Node node ,Node pNode,int level){
        if(level ==0 ){
            System.out.print(node.data+" ");
            return;
        }
        if(node.left!=null && node.left!=pNode){
            kDown(node.left,pNode, level-1);
        }
        if(node.right!=null && node.right!=pNode ){
            kDown(node.right, pNode, level-1);
        }
    }


    public static void levelOrdertraversal(){
        int h =height(root);
        for (int i = 0; i <= h; i++) {
            printHieghtWise(root, 0, i);
        }
    }


    public static void printHieghtWise(Node node,int level ,int levelToprint){
       if(node ==null)return ;
       if(level==levelToprint){
           System.out.print(node.data+" ");
           return ;
       }
       printHieghtWise(node.left, level+1, levelToprint);
       printHieghtWise(node.right,level+1, levelToprint);
    }


    public static void printBoundary(Node root){
       printLeftNodes(root);
       printLeaf(root);
       printRightNodes(root,root);
    }

    private static void printLeftNodes(Node node) {
        System.out.print(node.data+" ");
        if(node.left!=null&&node.left.left!=null){
            printLeftNodes(node.left);
        }
    }


    private static void printRightNodes(Node node,Node root) {
        if(node.right!=null&&node.right.right!=null){
            printRightNodes(node.right,root);
        }
        if(node!=root) System.out.print(node.data+" ");
    }

    private static void printLeaf(Node node){
       if(node==null) return ;
       if(node.left==null&&node.right==null){
           System.out.print(node.data+" ");
        }

        printLeaf(node.left);
        printLeaf(node.right);
    }



}