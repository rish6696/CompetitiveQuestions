import java.util.*;

public class IpAdress{
    public static void main(String[] args) {
        List<String> ansList=new ArrayList<>();
        String str="010010";
        String tempAns=new String(str);
        getValidIps(ansList, str, tempAns, 0, 1,-1);
        System.out.println(ansList);
       
        
    }

    public static boolean isValidNum(String ans){
        if(ans.charAt(0)=='0'&&ans.length()>1){
            return false;
        }
        int sum=0;
        for(int i=0;i<ans.length();i++){
            int val=ans.charAt(i)-'0';
            sum=sum*10+val;
        }

        return sum >=0 &&sum<=255;
    }

    public static void getValidIps(List<String> ansList,String str,String tempAns,int idx,int dot,int prevDot){
        if(dot==4){
            int lastSectionSize=str.length()-idx;
            if(lastSectionSize>=1&&lastSectionSize<=3&&isValidNum(tempAns.substring(prevDot+1,tempAns.length()))) ansList.add(tempAns);
            return ;
        }
        for(int i=0;i<3;i++){
            int dotIndex=idx+i;
            int tempAnsIterator=dotIndex+(dot-1);
            if(dotIndex<str.length()&&isValidNum(tempAns.substring(prevDot+1,tempAnsIterator+1))){ 
                getValidIps(ansList, str, tempAns.substring(0, tempAnsIterator+1)+"."+tempAns.substring(tempAnsIterator+1) ,dotIndex+1, dot+1,tempAnsIterator+1);
            }
        }
    }
}