import java.util.Arrays;
import java.util.Comparator;
public class DSUQues {

    public static class DSU {
        int[] parents;
        int[] sizeArray;

        public DSU(int size) {
            parents = new int[size];
            sizeArray = new int[size];
            for (int i = 0; i < parents.length; i++) {
                parents[i]=i;
                sizeArray[i]=1;
            }
        }

        public void unioun(int p1,int p2){
          if(sizeArray[p1] <sizeArray[p2] ){
              parents[p1]=p2;
              sizeArray[p2]=sizeArray[p1];
          }else{
            parents[p2]=p1;
            sizeArray[p1]=sizeArray[p2];
          }
        }

        public  int find(int vtx){
          if(parents[vtx]==vtx)return vtx;
          int recParent =find(parents[vtx]);
          parents[vtx]=recParent;
          return parents[vtx];
        }
    }

    public static void main(String[] args) {
        int [][] arr ={{0,1,10},{0,2,20}};
        Arrays.sort(arr,new Comparator<int []>() {
            @Override
            public int compare(int [] arg0, int [] arg1) {
                return arg0[2]-arg1[2];
            }
        }); 
    }

}