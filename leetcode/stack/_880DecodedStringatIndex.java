public class _880DecodedStringatIndex{
    public static void main(String[] args) {

        String str = "aw4eguc6cs";
        System.out.println(decodeAtIndex(str, 41));
        
    }

    public static  String decodeAtIndex(String S, int K) {

        if(K ==1) return S.charAt(0)+"";
        
        int ii =1;
        int ai =1;
        
    
        StringBuilder str =new StringBuilder();
        str.append(S.charAt(0));
        for(int i =1;i<S.length();i++){

         
            char cc = S.charAt(i);
            if(cc-'0' >=0 && cc-'0'<=9){
                int num =cc -'0'-1;
                ii+= ii*num;     
            }else{
                str.append(cc);
                ai++;
                ii++;
                
            }

            if(K == ii) return str.charAt(ai-1)+"";
            if(K <= ii){
                int idx =  K% ai;
                return str.charAt(idx-1)+"";
            }


            
            
        }
        
        return "";
        
    }
}