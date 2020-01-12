import java.util.ArrayList;
import java.util.Scanner;

public class Days{
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
    //    System.out.println(giveStart("wed", 7));
       int test=s.nextInt();
       ArrayList<Integer> days=new ArrayList<>();
       ArrayList<String> name=new ArrayList<>();
       for(int i=0;i<test;i++) {
          days.add(s.nextInt());
          name.add(s.next());
       }
       result(days, name);
    

    }
    public static int valueref(String name){
        switch (name) {
            case "mon":
              return 1;
            case "tues":
              return 2;
            case "wed":
              return 3;
              case "thurs":
              return 4;
              case "fri":
              return 5;
              case "sat":
              return 6;
              case "sun":
              return 7;
        
            default:
                return 0;
        }
    }

    public static int giveStart(String start,int ques){
        int sval=valueref(start);
        int ans=ques-sval;
        if(ans<0){
            ans=ans+7;
        }
        return ans+1;
    }

    public static void result(ArrayList<Integer>days,ArrayList<String> name){
        for(int i=0;i<days.size();i++){
            int totalDays=days.get(i);
            String dayName=name.get(i);
            for(int j=1;j<=7;j++){
                int count =0;
                int ans=giveStart(dayName, j);
                while(ans<=totalDays){
                    count++;
                    ans+=7;
                    
                }
                System.out.print(count+" ");
            }
            System.out.println();

        }
    }

}