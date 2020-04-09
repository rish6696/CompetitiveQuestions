public class Client{
    public static void main(String[] args) {
        StackUsingQueue st =new StackUsingQueue();
        st.push(1);
        st.push(2);

        System.out.println(st.top());
        System.out.println(st.pop());

        System.out.println(st.empty());
    }
}