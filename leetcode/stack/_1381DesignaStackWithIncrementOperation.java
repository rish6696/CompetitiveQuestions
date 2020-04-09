public class _1381DesignaStackWithIncrementOperation{
    public static void main(String[] args) {
        CustomStack st =new CustomStack(3);
        st.push(1);
        st.push(2);

        System.out.println(st.pop());

        st.push(2);
        st.push(3);
        st.push(4);

        st.increment(5, 100);
        st.increment(2, 100);

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}