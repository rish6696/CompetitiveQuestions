import java.util.ArrayList;

public class StickerWord{
    public static void main(String[] args) {
        String ques="abcel";
        String[] dic= {"abcml","abcp","abce"};
        int [] numUsed=new int [dic.length];
        ArrayList<String> bag=new ArrayList<>();
        System.out.println(stickerWord(0, ques, numUsed, bag, dic));
    }

    public static int getUsedfreq(int[] usedFreq){
        int ans=0;
        for (int i : usedFreq)  ans+=i;
        return ans;
    }
 

    public static int stickerWord(int idx,String ques,int[]usedFreq,ArrayList<String> bag,String[]dic){
        if(idx==ques.length()){
           // System.out.println(getUsedfreq(usedFreq));
            return getUsedfreq(usedFreq);
        }

        int ans=Integer.MAX_VALUE;
        char cc=ques.charAt(idx);
        for (int i = 0; i <dic.length ; i++) {
            String diccc =dic[i];
            for (int j = 0; j < diccc.length(); j++) {
                if(cc==diccc.charAt(j)){
                    int usedFreqval=usedFreq[i];
                    usedFreq[i]=usedFreqval+1;
                    bag.add(diccc.substring(0, j)+diccc.substring(j+1));
                    ans=Math.min(ans,stickerWord(idx+1, ques, usedFreq, bag, dic));
                    usedFreq[i]=usedFreqval;
                    bag.remove(bag.size()-1);

                }
            }
        }
        for(int i=0;i<bag.size();i++){
            String bc=bag.get(i);
            for (int j = 0; j < bc.length(); j++) {
                if(bc.charAt(j)==cc){
                    String prevVal=bag.get(i);
                    bag.set(i,bc.substring(0, j)+bc.substring(j+1));
                    ans=Math.min(ans, stickerWord(idx+1, ques, usedFreq, bag, dic));
                    bag.set(i, prevVal);
                }
                
            }
        }
        return ans == Integer.MAX_VALUE ? -1 :ans;

     
    
    }

}


