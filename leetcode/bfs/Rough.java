import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Rough{
    public static void main(String[] args) {
        // Integer[] array ={2, 3, 3, 3, 4, 4, 5, 5, 6,6,6,6,6,6 } ;
        // List<Integer> ans =Arrays.asList(array);
        // List<Integer> mode =new ArrayList<>();
        // int best = Integer.MIN_VALUE;
        // int o=1;
        // for(int i=1;i<ans.size();i++){
        //     if(ans.get(i-1)==ans.get(i)){
        //         o++;
        //     }else{
        //         if(o>best){
        //             mode.clear();
        //             mode.add(ans.get(i-1));
        //             best =o;
        //         }else if(o==best){
        //            mode.add(ans.get(i-1));
        //         }
        //         o=1;
        //     }
        // }
        
        //  if(o>best){
        //             mode.clear();
        //             mode.add(ans.get(ans.size()-1));
        //             best =o;
        //             o=1;
        //         }else if(o==best){
        //            mode.add(ans.get(ans.size()-1));
        //            o=1;
        // }


        String s= "1-2--3--4-5--6--7";
        int [] arr= getArray(s);
        System.out.println(Arrays.toString(arr));

    }


    

    public static int getNum(String str,int[] idx){
        int start =idx[0];
        int end =idx[0];
        while(end<str.length()&&str.charAt(end)!='-'){
            end++;
        }
        idx[0]=end;
        return Integer.parseInt(str.substring(start,end));
    }

    public static int getLevel(String str,int[] idx){
        int start =idx[0];
        int end =idx[0];
        while( end<str.length()&& str.charAt(end)=='-' ){
            end++;
        }
        idx[0]=end;
        return end-start;     
    }
    
    public static int [] getArray(String str){
        List<Integer> list =new ArrayList<>();
        int[] idx =new int []{0};
        int plevel =-1;
        while(idx[0]< str.length()){
              int   level = getLevel(str,idx);
              int   val =   getNum(str,idx);
              if(level <= plevel){
                  int diff =plevel-level;
                  diff+=2;
                  int i =1;
                  while(i<=diff){
                      list.add(-1);
                      i++;
                  }
              }
              list.add(val);
            plevel=level;
        
              
        }
        int [] ans =new int [list.size()+2];
        ans[ans.length-1]=-1;
        ans[ans.length-2]=-1;
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }





}


