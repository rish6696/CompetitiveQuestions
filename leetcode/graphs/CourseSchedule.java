import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class CourseSchedule{

    public static List< List<Integer>  > graph =new ArrayList<>();


    
    public static void main(String[] args) {
        int n=3;
        int [][] prequisite= {{1,0},{1,2},{0,1}};
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int [] inDeegreeArray=new int [n];
         getGraph(prequisite,inDeegreeArray);

        System.out.println(graph);
       // System.out.println(Arrays.toString(inDeegreeArray));


         int [] ans =khanTopo(graph, inDeegreeArray);
         System.out.println(Arrays.toString(ans));




        // System.out.println(graph);
        // boolean [] visited=new boolean [n];
        // boolean [] inStack=new boolean [n];
        // for (int i = 0; i < visited.length; i++) {
        //     if(!visited[i]){
        //         boolean ans =detectCycle(graph, i, visited, inStack);
        //         if(ans){
        //             System.out.println("there is cycle");
        //             return ;
        //         }
        //     }
        // }
        // System.out.println("There is no cycle");
    }


    public static void  getGraph(int[][]prequisite,int []inDeegreeArray){
        for (int i = 0; i < prequisite.length; i++) {
            int [] a=prequisite[i];
            int f=a[0];
            int s=a[1];
            inDeegreeArray[f]++;
            graph.get(s).add(f);
        }
    }

    public static boolean detectCycle(List< List<Integer>  > graph ,int source,boolean[]visited,boolean[]inStack){
       visited[source]=true;
       inStack[source]=true;
       List<Integer> indexList =graph.get(source);
       for(int i=0;i<indexList.size();i++){
           if(!visited[indexList.get(i)]){
               boolean recAns=detectCycle(graph,indexList.get(i) , visited, inStack);
               if(recAns)return true;
           }else{
               if(inStack[indexList.get(i)]){
                   return true;
               }
           }

       }
       inStack[source]=false;
       return false;
    }

    public static int []khanTopo(List< List<Integer>  > graph,  int [] inDeegreeArray){
      LinkedList <Integer> queue =new LinkedList<>();
      List<Integer> stack =new ArrayList<>();
      for (int i = 0; i < inDeegreeArray.length; i++) {
          if(inDeegreeArray[i]==0){
              queue.add(i);
          }
      }
      while(!queue.isEmpty()){
          int front =queue.removeFirst();
           stack.add(front);
          for(int n:graph.get(front)){
            inDeegreeArray[n]--;
            if(inDeegreeArray[n]==0)queue.addLast(n);
          }
      }
      if(stack.size()<graph.size()){
          return new int [0];
      }
      int [] ans =new int [stack.size()];
      for (int i = 0; i < ans.length; i++) {
          ans[i]=stack.get(i);
      }
      return ans ;
    
    }

    
}