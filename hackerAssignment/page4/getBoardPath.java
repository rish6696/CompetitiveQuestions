import java.util.ArrayList;

public class getBoardPath{
    public static void main(String[] args) {
        System.out.println(getBoard(0, 4));
        
    }

    public static ArrayList<String> getBoard(int start,int end){
        if(start==end){
            ArrayList<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        if(start>end){
            ArrayList<String> base=new ArrayList<>();
            return base;
        }
        ArrayList<String> recAns=null;
        ArrayList<String> result=new ArrayList<>();
        
        for(int dice=1;dice<=6;dice++){
            recAns=getBoard(start+dice, end);
            for(int i=0;i<recAns.size();i++){
                result.add(dice+recAns.get(i));
            }
           
        }
        return result;
    }
}