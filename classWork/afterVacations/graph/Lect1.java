import java.util.ArrayList;

public class Lect1{

    public static ArrayList<ArrayList<Edge>> graph =new ArrayList<>();
    public static class Edge {
       int v=0;
       int w=0;
       public Edge(int v,int w){
           this.v=v;
           this.w=w;

       }
    }

  
    public static void  createGraph(int n){
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(0, 1, 10);
        addEdge(0, 3, 10);
        addEdge(1, 2, 10);
        addEdge(2, 3, 40);
        addEdge(3, 4, 2);
        addEdge(4, 5, 2);
        addEdge(4, 6, 3);
        addEdge(5, 6, 8);

        

    }

    public static void addEdge(int u,int v,int w){
        if(u<0 || v<0 || u>=graph.size()|| v>=graph.size()) return ;
        graph.get(u).add(new Edge(v, w));
        graph.get(v).add(new Edge(u, w));

    }


    public static void display(){
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i+"->");
            for (int j = 0; j <graph.get(i).size(); j++) {
                System.out.print("("+graph.get(i).get(j).v+","+graph.get(i).get(j).w+")");
            }
            System.out.println();
        }
    }

    public static Edge  removeEdge(int u,int v){
        ArrayList<Edge> m =graph.get(u);
        ArrayList<Edge> n =graph.get(v);
        int w=0;

        for (int i = 0; i < m.size(); i++) {
            if(m.get(i).v==v){
                w=m.get(i).w;
                m.remove(i);
            }
        }

        for (int i = 0; i < n.size(); i++) {
            if(n.get(i).v==u){
                n.remove(i);
            }
        }
        return new Edge(v, w);

    }

    public static void removeVertex(int vertex){
      ArrayList<Edge> indexList =graph.get(vertex);
      while(indexList.size()!=0){
          removeEdge(vertex , indexList.get(indexList.size()-1).v);
      }
      
    }

    public static void main(String[] args) {
        createGraph(7);
        display();
        System.out.println("*******************");
        removeVertex(3);
        display();

    }
}