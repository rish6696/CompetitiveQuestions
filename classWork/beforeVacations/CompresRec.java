public class CompresRec{
    public static void main(String[] args) {
        String str="maaabaaapq";
        System.out.println(comPress(str, 1, "", 1));
        
    }

    public static String comPress(String str,int count,String result,int start){
        if(start==str.length()){
            if(count>1){
                return result+str.charAt(start-1)+count;
            }
            return result+str.charAt(start-1);
        }
        
        if(str.charAt(start)==str.charAt(start-1)){
              return comPress(str, count+1 , result, start+1);
        }else{
            if(count>1) return comPress(str, 1, result+str.charAt(start-1)+count ,start+1);
            return comPress(str, 1, result+str.charAt(start-1) ,start+1);
        }
    }
}