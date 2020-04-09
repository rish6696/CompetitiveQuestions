import java.util.Stack;
public class _394DecodeString{
    public static void main(String[] args) {
        String str ="3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        System.out.println(decodeString(str));

    }

    public static String decodeString(String s) {
        
        StringBuilder ans =new StringBuilder();
        StringBuilder temp =new StringBuilder();
        StringBuilder toAdd =new StringBuilder();

        StringBuilder num =new StringBuilder();
        
        Stack<String> stack =new Stack<>();
        for(int i =0;i< s.length();i++ ){
            String  cc =s.charAt(i)+"";
            if(!cc.equals("]"))   stack.push(cc+"");
            else {
                temp.setLength(0);
                toAdd.setLength(0);
                num.setLength(0);
                while(!stack.isEmpty()  && !stack.peek().equals("[")  ){
                    temp.insert(0,stack.pop());
                }
                
                stack.pop();
            
                // gather the value of k 
                while(!stack.isEmpty() && stack.peek().charAt(0)-'0' >= 0&&stack.peek().charAt(0)-'0'<=9){
                    num.insert(0,stack.pop());
                }

                int k =Integer.parseInt(num.toString());


                while(k>0){
                    toAdd.append(temp);
                    k--;
                }
                stack.push(toAdd.toString());
            }
        }
        
        
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }
        
        return ans.toString();
        
    }
}