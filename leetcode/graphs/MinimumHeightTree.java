import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class MinimumHeightTree{
    public static void main(String[] args) {
        ArrayList[] n =new ArrayList[4];
        for (int i = 0; i < n.length; i++) {
            System.out.println(n[i].get(0));
        }

    //     int sizeGraph =6;
    //     List< List<Integer> > graph =new ArrayList<>();

    //     int [][] input={{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
    //     int [] indeegre =new int [sizeGraph];
    //    //int [][] input={{1, 0}, {1, 2}, {1, 3}};
    //     createGraph(input, graph, sizeGraph,indeegre);
    //    // List <Integer> ans =maxHeightSolution(graph, sizeGraph);
    //    // System.out.println(ans);

    //    System.out.println(maxheightSol(graph, sizeGraph, indeegre));

    }



    //brute force solution 

    public static List <Integer> maxHeightSolution(List< List<Integer> > graph,int size){
        int [] ansStrg=new int [size];
        for (int i = 0; i < ansStrg.length; i++) {
            boolean[]visited =new boolean [size];
            int maxlevel =Integer.MIN_VALUE;
            LinkedList<Integer> queue =new LinkedList<>();
            queue.add(i);
            int level =0;
            while(!queue.isEmpty()){
                int qsize =queue.size();
                while(qsize > 0){
                   qsize--;
                   int front =queue.removeFirst();
                   maxlevel=Math.max(maxlevel, level);
                   visited[front]=true;
                   for(Integer nie:graph.get(front)){
                       if(!visited[nie]){
                           queue.addLast(nie);
                       }
                   }
                }
                level++;

            }
            ansStrg[i]=maxlevel;
        }

        int min =Integer.MAX_VALUE;
        List<Integer> ans =new ArrayList<>();
        for (int i = 0; i < ansStrg.length; i++) {
            min=Math.min(min, ansStrg[i]);
        }
        for (int i = 0; i < ansStrg.length; i++) {
            if(ansStrg[i]==min){
                ans.add(i);
            }
        }
        return ans ;

    }


    public static void createGraph(int [][] input, List< List<Integer> > graph,int size,int[]inDeegre){
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < input.length; i++) {
            int f =input[i][0];
            int s =input[i][1];
            graph.get(f).add(s);
            graph.get(s).add(f);
            inDeegre[f]++;
            inDeegre[s]++;
        }
    }


    ///my optimised Solution from leetcode help i.e explained below

    public static  List <Integer> maxheightSol(List< List<Integer> > graph,int size,int[]inDeegre){
        LinkedList<Integer> queue =new LinkedList<>();
        int totalNodes =size;


        for (int i = 0; i < inDeegre.length; i++) {
            if(inDeegre[i]==1)queue.addLast(i);
        }
        while(totalNodes>2){
            int queueSize =queue.size();
            totalNodes-=queueSize;
            for (int i = 0; i < queueSize; i++) {
                int front =queue.removeFirst();
                for(int nie:graph.get(front)){
                   inDeegre[nie]--;
                   if(inDeegre[nie]==1){
                       queue.addLast(nie);
                   }
                }
            }
        }
        List<Integer> ans =new ArrayList<>();
        ans.addAll(queue);
        return ans ;
    } 




    //leetcode solution
    public static  List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> r = new ArrayList<Integer>();
        if(n <= 0){
            return r;
        }
        /* with only one node, since its in-degree will be 0, therefore, we need to handle it separately */
        if(n == 1){
            r.add(0);
            return r;
        }
        
        HashMap<Integer, HashSet<Integer>> graphs = new HashMap<Integer, HashSet<Integer>>();
        HashMap<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
        /* initialize in-degree and graph */
        for(int i=0; i < n; i ++){
            graphs.put(i, new HashSet<Integer>());
            inDegree.put(i, 0);
        }
        
        /* build graph */
        for(int edge[]: edges){
            int n1 = edge[0];
            int n2 = edge[1];
            /* un directed so we need to add both the edges on both the nodes */
            graphs.get(n1).add(n2);
            graphs.get(n2).add(n1);
            /* add the indegree on both the nodes as its undirected */
            inDegree.put(n1, inDegree.get(n1) + 1);
            inDegree.put(n2, inDegree.get(n2) + 1);
        }
        int totalNodes = n;
        Queue<Integer> leafs = new LinkedList<Integer>();
        /* childs with one in degree which means its a leaf node */
        for(Map.Entry<Integer,Integer> eachIn: inDegree.entrySet()){
            if(eachIn.getValue() == 1){
                leafs.add(eachIn.getKey());
            }
        }
        
        /*
		Remove leaves level by level and subtract each leave's children's in-degrees.
        Repeat this until we are left with 1 or 2 nodes, which will be our answer.
        Any node that has already been a leaf cannot be the root of a minimum height tree, because 
        its adjacent non-leaf node will always be a better candidate.
		*/
        while(totalNodes > 2){
            int leafSize = leafs.size(); 
            totalNodes -= leafSize;
            for(int i=0; i < leafSize; i ++){
                int vertex = leafs.poll();
                for(int child: graphs.get(vertex)){
                    inDegree.put(child, inDegree.get(child) - 1);
                    if(inDegree.get(child) == 1){
                        leafs.offer(child);
                    }
                }    
            }
        }
        
        r.addAll(leafs);
        return r;
    }
}