public class Index{
    public static void main(String[] args) {
        int[]arr={1,3,5,4,2,6};

        System.out.println(subsetSum(arr, 9, 0, ""));
        
    }

//     public class Node{
//         //
//     }

//     public static void TreeMirror(Node node,Node parent,boolean isLeft){

//         if(node.left==null&&node.right==null){
//             if(isleft){
//                 Node right=parent.right;
//                 parent.right=node;
//                 parent .left=right;
//                 return ;
//             }
//         }
//         if(node.left!=null){
//             TreeMirror(node.left, node, true);
//         }
//         if(node.right!=null){
//             TreeMirror(node.right, node, false);
//         }

//     }
// }


public static int subsetSum(int[]arr,int sum,int start,String ans){
    if(sum==0){
        System.out.println(ans);
        return 1;
    }
    int count =0;
    for(int i=start;i<arr.length;i++){
        if(sum-arr[i]>=0){
        count+=subsetSum(arr, sum-arr[i],i+1,ans+arr[i]);
        }
    }
    return count;
}
} 