import java.util.ArrayList;
public class CombinationIterator {
    int counter=0;
    int length;
    ArrayList<String> ans;
    String ques;
    public CombinationIterator(String ques,int length){
        this.length=length;
        this.ques=ques;
        ans=new ArrayList<>();
        generateResult("", 0);
    }
    public void generateResult(String temp,int start){
        if(temp.length()==this.length){
            ans.add(temp);
            return ;
        }
        for(int i=start;i<ques.length();i++){
            generateResult(temp+ques.charAt(i), i+1);
        }
    }
    public boolean hasNext(){
        return counter< ans.size();
    }

    public String next(){
        if(counter<ans.size()){
            
            String toSend=ans.get(counter);
            counter++;
            return toSend;
            
        }
        return "";
    }
}