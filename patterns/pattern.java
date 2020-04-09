public class pattern{
    public static void main(String[] args) {
        int n=7;
        int irow=0;
        int space=n-1;
        int star=1;
        while(irow<n){
            int ispace=1;
            while(ispace<=space){
                System.out.print("  ");
                ispace++;
            }
            int istar=1;
            int val = irow+1;
            while(istar<=star){
                System.out.print(val+" ");
                if(istar<=irow) val++;
                else val--;
                istar++;
            }
            space--;
            star+=2;
            System.out.println();
            irow++;
        }
    }
    //     int n =7;
    //     int nsp=n-1;
    //     int csp =0;
    //     int nnum =1;
    //     int cnum =1;

    //     int row =1;
    //     while(row<=n){

    //         csp =1;
    //         while(csp<=nsp){
    //             System.out.print("  ");
    //             csp++;
    //         }

    //         cnum =1;
    //         int num =row;
    //         while(cnum<=nnum){
    //             System.out.print(num+" ");
    //             cnum++;
    //             if(cnum<=row) num++;
    //             else num --;
    //         }

    //         System.out.println();
    //         row++;
    //         nnum+=2;
    //         nsp--;
    //     }
    // }
}