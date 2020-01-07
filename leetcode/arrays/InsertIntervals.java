import java.util.*;
public class InsertIntervals{
    public static void main(String[] args) {
        // int[][] intervals={{1,2},{3,5},{6,7},{8,10},{12,16}};
        // int[] newInterval={4,8};

        int[][] intervals= {{1,5}};
        int[] newInterval={2,3};
        int[][] sol =alternate(intervals, newInterval);
        for (int i = 0; i < sol.length; i++) {
            System.out.println(Arrays.toString(sol[i]));
        }
    }


    ///alternateSolution 
    public static int [][] alternate(int[][] intervals, int[] newInterval){


        //if array is of length o
        if(intervals.length==0){
            int[][] ans=new int[1][2];
            ans[0]=newInterval;
            return ans;

        }

        // item to be inserted is the first 
        if(newInterval[1]<intervals[0][0]){
            int[][] ans=new int[intervals.length+1][2];
            for (int i = 1; i < ans.length; i++) {
                ans[i]=intervals[i-1];
            }
            ans[0]=newInterval;
            return ans ;
        }

        //if item to be inserted is the last
        if(newInterval[0]>intervals[intervals.length-1][1]){
            int[][] ans=new int[intervals.length+1][2];
            for (int i = 0; i < intervals.length; i++) {
                ans[i]=intervals[i];
            }
            ans[ans.length-1]=newInterval;
            return ans ;
        }
        boolean didOverlap=false;
        // checks did there is any overlap.
        for (int i = 0; i < intervals.length; i++) {
            if(newInterval[0]<=intervals[i][0] && intervals[i][0]<=newInterval[1]|| newInterval[0]<=intervals[i][1]&& newInterval[1]>=intervals[i][1]){
                intervals[i][1]=Math.max(intervals[i][1], newInterval[1]);
                intervals[i][0]=Math.min(intervals[i][0], newInterval[0]);
                didOverlap=true;
            }
        }
         // if there is overlaps then this function solves overlapping 
         //check the ques MergeIntervals in same folder (done on leetcode )
        if(didOverlap){
            int i=1;
        int vIndex=0;
        while (i < intervals.length) {
              if(intervals[i][0]<=intervals[vIndex][1]){
                intervals[vIndex][1]=Math.max(intervals[vIndex][1], intervals[i][1]);
              }else {
                vIndex++;
                intervals[vIndex]=intervals[i];
              }
              i++;
        }

        int [][] ans =new int [vIndex+1][2];
        for (int j = 0; j <=vIndex; j++) {
            ans[j]=intervals[j];
            
        }
        return ans;
        }
        else{
            //if the new intervals is not overlapping but come somewhere in between 
            int indexToInsert=-1;
            for (int i = 0; i < intervals.length-1; i++) {
                if(newInterval[0]>intervals[i][1]&&newInterval[1]<intervals[i+1][0]){
                    indexToInsert=i+1;
                }
            }
            if(indexToInsert!=-1){
                int [][] ans =new int [intervals.length+1][2];
            for (int i = 0; i < ans.length; i++) {
                if(i<indexToInsert){
                    ans[i]=intervals[i];
                }else if(i==indexToInsert){
                    ans[i]=newInterval;
                }else{
                    ans[i]=intervals[i-1];
                }
            }
            return ans ;
            }else{
                return intervals;
            }

        }
    }

   
}