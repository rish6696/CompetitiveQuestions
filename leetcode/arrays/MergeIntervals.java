import java.util.*;

public class MergeIntervals{
    public static void main(String[] args) {
        List<int[]> solution =new ArrayList<>();
       // int [][]arr={{362,367},{314,315},{133,138},{434,443},{202,203},{144,145},{229,235},{205,212},{314,323},{128,129},{413,414},{342,345},{43,49},{333,342},{173,178},{386,391},{131,133},{157,163},{187,190},{186,186},{17,19},{63,69},{70,79},{386,391},{98,102},{236,239},{195,195},{338,338},{169,170},{151,153},{409,416},{377,377},{90,96},{156,165},{182,186},{371,372},{228,233},{297,306},{56,61},{184,190},{401,403},{221,228},{203,212},{39,43},{83,84},{66,68},{80,83},{32,32},{182,182},{300,306},{235,238},{267,272},{458,464},{114,120},{452,452},{372,375},{275,280},{302,302},{5,9},{54,62},{237,237},{432,439},{415,421},{340,347},{356,358},{165,168},{15,17},{259,265},{201,204},{192,197},{376,383},{210,211},{362,367},{481,488},{59,64},{307,315},{155,164},{465,467},{55,60},{20,24},{297,304},{207,210},{322,328},{139,142},{192,195},{28,36},{100,108},{71,76},{103,105},{34,38},{439,441},{162,168},{433,433},{368,369},{137,137},{105,112},{278,280},{452,452},{131,132},{475,480},{126,129},{95,104},{93,99},{394,403},{70,78}};
        int [][]arr={{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        mergeIntervalsOptimised(arr, solution);
        
        
    }


    public static void mergeIntervalsOptimised(int[][] arr,List<int []>solution){
        

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] entry1, int[] entry2) {
                return entry1[0] - entry2[0];
            }
        });

        int i=1;
        int vIndex=0;
        while (i < arr.length) {
              if(arr[i][0]<=arr[vIndex][1]){
                arr[vIndex][1]=Math.max(arr[vIndex][1], arr[i][1]);
              }else {
                vIndex++;
                arr[vIndex]=arr[i];
              }
              i++;
        }

        int [][] ans =new int [vIndex+1][2];
        for (int j = 0; j <=vIndex; j++) {
            ans[j]=arr[j];
            
        }

        for (int j = 0; j <ans.length; j++) {
            System.out.println(Arrays.toString(ans[j]));
        }


         
    }



    public static void mergeIntervals(int[][] arr,List<int []>solution){
        Stack<int[]> stack=new Stack<>();

      


        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] entry1, int[] entry2) {
                return entry1[0] - entry2[0];
            }
        });


        for (int j = 0; j < arr.length; j++) {
            System.out.println(Arrays.toString(arr[j]));
        }

        System.out.println("*******************************");

        int i=1;
        if (arr.length>0) stack.push(arr[0]);
        while (i < arr.length) {
              int [] top=stack.peek();
              if(arr[i][0]<=top[1]){
                arr[i][0]=top[0];
                arr[i][1]=Math.max(top[1], arr[i][1]);
                stack.pop();
                stack.push(arr[i]);  
              }else {
                stack.push(arr[i]);
              }
              i++;
        }

        int [][] ans =new int[stack.size()][2];
        i=0;

        while(!stack.isEmpty()){
            ans[i]=stack.pop();
            i++;
        }


        for (int j = 0; j < ans.length; j++) {
            System.out.println(Arrays.toString(ans[j]));
        }


         
    }

}