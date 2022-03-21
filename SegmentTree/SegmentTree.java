import java.util.Arrays;

public class SegmentTree {

    int[] maxNodes;
    int[] sumNodes;
    int n;

    public SegmentTree(int[] arr) {
        this.maxNodes = new int[4 * arr.length];
        this.sumNodes = new int [4*arr.length];
        this.n = arr.length;
        buildMaxTree(0, arr.length-1, 0, arr);
        buildSumTree(0, arr.length-1, 0, arr);
    }



    public void printSegmentTree(){
        System.out.println("Max Array => "+Arrays.toString(maxNodes));
        System.out.println("Sum Array => "+Arrays.toString(sumNodes));
    }

    // this function role is to construct and return the node value 
    private int  buildMaxTree(int left ,int right,int index,int [] arr){

        if (left == right){
            this.maxNodes[index] = arr[left];
            return arr[left];
        }

        int mid = (left + right)/2;

        int leftNode = buildMaxTree(left, mid, 2*index+1,arr);
        int rightNode = buildMaxTree(mid+1, right, 2*index+2,arr);

        this.maxNodes[index]= Math.max(leftNode, rightNode);
        return this.maxNodes[index];
    }

    private int  buildSumTree(int left ,int right,int index,int [] arr){

        if (left == right){
            this.sumNodes[index] = arr[left];
            return arr[left];
        }

        int mid = (left + right)/2;

        int leftNode = buildSumTree(left, mid, 2*index+1,arr);
        int rightNode = buildSumTree(mid+1, right, 2*index+2,arr);

        this.sumNodes[index]= leftNode+rightNode;
        return this.sumNodes[index];
    }

    public int maxQuery(int left, int right){
        return this.maxQuery(0,0,this.n-1,left,right);
    }

    private int maxQuery(int index, int left,int right,int leftQuery,int rightQuery){

        // exactly overLapping Case
        if(leftQuery <= left  && rightQuery >= right ){
            return this.maxNodes[index];
        }

        //No OverLapping Case
        if(rightQuery < left || leftQuery > right ){
           return Integer.MIN_VALUE;
        }

        int mid = (left + right) /2;

        int leftAns = maxQuery(2*index+1, left,mid, leftQuery,rightQuery);
        int rightAns = maxQuery(2*index+2, mid+1, right, leftQuery, rightQuery);

        return Math.max(leftAns,rightAns);
    }


    public int sumQuery(int left, int right){
        return this.sumQuery(0,0,this.n-1,left,right);
    }

    private int sumQuery(int index, int left,int right,int leftQuery,int rightQuery){

        // exactly overLapping Case
        if(leftQuery <= left  && rightQuery >= right ){
            return this.sumNodes[index];
        }

        //No OverLapping Case
        if(rightQuery < left || leftQuery > right ){
           return 0;
        }

        int mid = (left + right) /2;

        int leftAns = sumQuery(2*index+1, left,mid, leftQuery,rightQuery);
        int rightAns = sumQuery(2*index+2, mid+1, right, leftQuery, rightQuery);

        return leftAns + rightAns;
    }
}
