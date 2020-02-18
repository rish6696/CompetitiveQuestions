import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class _854KSimilarStrings{
    public static void main(String[] args) {
        String A="bccaba";
        String B ="abacbc"; 
        System.out.println(bfs(A.toCharArray(), B.toCharArray()));
    }


    public static class KSimilar_854Pair{
        String  str;
        int idx ;
        int swaps;
        public KSimilar_854Pair(String str,int idx,int swaps){
            this.str=str;
            this.idx=idx;
            this.swaps=swaps;
        }
    }

    public static int bfs(char []A,char [] B){
        LinkedList<KSimilar_854Pair> queue =new LinkedList<>();
        queue.add(new KSimilar_854Pair(new String(B), 0, 0));
        HashSet<String> visited =new HashSet<>();
        while(!queue.isEmpty()){
            KSimilar_854Pair pair =queue.removeFirst();
            int idx =pair.idx;
            char [] str=pair.str.toCharArray();
            while(str[idx]==A[idx]){
                idx++;
            }
            for(int i=idx+1;i<str.length;i++){
                if(str[i]==A[idx]){
                    str[i]=str[idx];
                    str[idx]=A[idx];
                    if(Arrays.equals(str, A)){
                       return pair.swaps+1;
                    }
                    String toAdd=new String(str);
                    if(!visited.contains(toAdd)){
                        visited.add(toAdd);
                        queue.addLast(new KSimilar_854Pair(new String(str), idx+1, pair.swaps+1));
                    }
                    str[idx]=str[i];
                    str[i]=A[idx];

                }
            }
        }
        return 0;

    }




}