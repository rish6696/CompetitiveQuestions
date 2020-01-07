import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class RemoveCharGeeks{
    public static void main(String[]args){
        Scanner s=new Scanner(System.in);
        ArrayList<ArrayList<String>> casesList=new ArrayList<>();
        int test=s.nextInt();
        for (int i = 0; i < test; i++) {
            ArrayList<String> slist=new ArrayList<>();
            slist.add(s.next());
            slist.add(s.next());
            casesList.add(slist);
        }

        solve(casesList);

    }
    public static void solve(ArrayList<ArrayList<String>>casesList){

      for(int i=0;i<casesList.size();i++){
           ArrayList<String> container=casesList.get(i);
           String first =container.get(0);
           String second=container.get(1);
           boolean[] map =new boolean[26];
           for(int k=0;k<second.length();k++){
               int idx=second.charAt(k)-'a';
               map[idx]=true;
           }
           String ans="";
           for (int j = 0; j < first.length(); j++) {
               char cc=first.charAt(j);
               int vcc=cc-'a';
               if(!map[vcc]) ans+=cc;
           }
           System.out.println(ans);

      }
    }

}