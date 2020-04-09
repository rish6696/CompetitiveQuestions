import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Heap {

    private ArrayList<Integer> arr ;

    private boolean isMax =false;

    public  Heap(boolean isMax){
      this.isMax= isMax;  
      this.arr=new ArrayList<>(); 
    }

    public Heap(){
        this(false);
    }

    public Heap(Integer []a,boolean isMax) {
        System.out.println("hii");
        this.arr=new ArrayList<Integer> (Arrays.asList(a));
        this.isMax=isMax;
        createHeap();
        
    }

    public Heap(Integer []a) {
       this(a,false);
       System.out.println("hello");
    }


    public void update(int idx){
        //
    }


    public void createHeap(){
        for(int i =this.arr.size()-1; i >=0 ; i--){
            downHeapify(i);
        } 
    }

    public void push(int val ){
        arr.add(val);
        int s =this.arr.size()-1;
        upHeapify(s);
    }


    public int top(){
        return arr.get(0);
    }


    public int pop(){
        int ans = arr.get(0);
        swap(0, arr.size()-1);
        arr.remove(arr.size()-1);
        downHeapify(0);
        return ans;
    }

    public int [] heapSort() {
       
       int size = this.arr.size()-1;

       while(size >=1){
           swap(0, size);
           size--;
           heapSortDownHeapify(0, size);
       }

       int [] ans =new int [this.arr.size()];
       int i =0;
       for(Integer a:this.arr){
           ans[i]=a;
           i++;
       }

       return ans;
    }


    public void heapSortDownHeapify(int idx,int size){
        int maxIndex = idx;
        
        int lci = 2 * idx +1;
        int rci = 2 * idx +2;

        if(lci <=size  && compareTo(maxIndex, lci)>0 ) maxIndex= lci ;

        if(rci <=size && compareTo(maxIndex, rci)>0 ) maxIndex =rci ;

        if(maxIndex!=idx){
          swap(maxIndex, idx);
          heapSortDownHeapify(maxIndex,size);
        }
    }

    public void downHeapify(int idx){
        int maxIndex = idx;
        
        int lci = 2 * idx +1;
        int rci = 2 * idx +2;

        if(lci < arr.size()  && compareTo(maxIndex , lci)>0) maxIndex= lci ;

        if(rci <arr.size() && compareTo(maxIndex, rci)>0 ) maxIndex =rci ;

        if(maxIndex!=idx){
          swap(maxIndex, idx);
          downHeapify(maxIndex);
        }
    }


    public void upHeapify(int idx){
       int pi = (idx - 1)/2;
       if(pi < 0 ) return ;
       if(compareTo(pi, idx)>0){
          swap(pi, idx);
          upHeapify(pi);
       }
    }

    public void swap(int i ,int j ){
        if( i ==j ) return ;
        int vi =arr.get(i);
        int vj =arr.get(j);

        this.arr.set(i, vj);
        this.arr.set(j, vi);
    }

    public void display(){
        StringBuilder str =new StringBuilder();
        display(0, str);
        System.out.println(str);
    }

    private  void display(int idx,StringBuilder ans){
        if(idx <0 || idx >=this.arr.size() ){
            return ;
        }

        int lci = 2 * idx +1;
        int rci = 2 * idx + 2;

        if( lci >= 0 && lci < this.arr.size()) ans.append(this.arr.get(lci));
        else ans.append("Null "); 

        ans.append("==> ");
        ans.append(this.arr.get(idx));
        ans.append("<== ");


        if( rci >= 0 && rci < this.arr.size()) ans.append(this.arr.get(rci));
        else ans.append("Null "); 

        ans.append("\n");

        display(lci,ans);
        display(rci,ans);


    }


    public int compareTo(int pi,int ci){
        if(isMax){
          return  this.arr.get(ci) -this.arr.get(pi);
        }else {
            return this.arr.get(pi)-this.arr.get(ci) ;
        }
    }
}