import java.util.Arrays;

public class SellStock{
    public static void main(String[] args) {
       // int[] arr={7,1,5,3,6,4};
       // System.out.println(sellStock(arr));
       int [] b=new int[]{1,9};
       System.out.println(Arrays.toString(b));
        
    }
    public static int sellStock(int[]arr){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int cuurPrice=arr[i];
            if(cuurPrice>buyPrice){
                int profit=cuurPrice-buyPrice;
                if(profit>maxProfit){
                    maxProfit=profit;
                }
            }else{
                buyPrice=cuurPrice;
            }
        }
        return maxProfit ==Integer.MIN_VALUE ?0:maxProfit;
    }


    public static int sellStockIII(int[]arr){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int cuurPrice=arr[i];
            if(cuurPrice>buyPrice){
                int profit=cuurPrice-buyPrice;
                if(profit>maxProfit){
                    maxProfit=profit;
                    buyPrice=Integer.MAX_VALUE;
                }
            }else{
                buyPrice=cuurPrice;
            }
        }
        return maxProfit ==Integer.MIN_VALUE ?0:maxProfit;
    }
}