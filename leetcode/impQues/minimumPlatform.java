import java.util.Arrays;

public class minimumPlatform {
  public static void main(String[] args) {
      int []arrival ={900, 940, 950, 1100, 1500, 1800};
      int [] dept ={910, 1200, 1120, 1130, 1900, 2000};
      System.out.println(minPlatform(arrival, dept));
  }


  public static int minPlatform(int[]arrival,int []dept){
     int ans =-1;
     int i =0;
     int j =0;
     int count =0;
     Arrays.sort(arrival);
     Arrays.sort(dept);
    while(i<arrival.length&&j<dept.length){
        if(arrival[i]<dept[j]){
            i++;
            count++;
        }else{
            j++;
            count--;
        }  
        ans=Math.max(ans, count);    
    }
    return ans;
  }
} 