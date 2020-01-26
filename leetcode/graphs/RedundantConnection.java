import java.util.Arrays;
public class RedundantConnection{
    public static void main(String[] args) {
        int [][] edges ={{3,4},{1,2},{2,4},{3,5},{2,5}};
        System.out.println(Arrays.toString(getEdgeRemoved(edges)));
    }
    public static int [] getEdgeRemoved(int[][] edges){
        int []ans=null;
        int [] parents =new int [edges.length];
        int [] size =new int [edges.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i]=i;
        }

        for (int i = 0; i < size.length; i++) {
            size[i]=1;
        }

        for (int i = 0; i < edges.length; i++) {
            int u =edges[i][0]-1;
            int v =edges[i][1]-1;

            int parentU=findParent(parents, u);
            int parentV=findParent(parents, v);
            if(parentU==parentV){
                ans =edges[i];
            }
            else{
               if(size[parentU]>=size[parentV]){
                parents[parentV]=parentU;
                size[parentU]++;
               }else{
                parents[parentU]=parentV;
                size[parentV]++;
               }
            }

        }

        return ans ;

    }

    public static int findParent(int [] parents,int ques) {
        if(ques!=parents[ques]){
            return findParent(parents, parents[ques]);
        }
        return ques;
    }
}