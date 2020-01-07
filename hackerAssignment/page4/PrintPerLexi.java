public class PrintPerLexi {
    public static void main(String[] args) {
        String str="abc";
        StringBuilder m=new StringBuilder(str);
        permuLexiOrder(m, 0);


    }


    public static void permuLexiOrder(StringBuilder str,int level){
        if(level==str.length()-1){
            System.out.println(str);
            return ;
        }

        for(int i=level;i<str.length();i++){
            StringBuilder copy=new StringBuilder(str);
            char temp=str.charAt(level);
            copy.setCharAt(level, copy.charAt(i));
            copy.setCharAt(i, temp);
            permuLexiOrder(copy,level+1);
        }
    }
}