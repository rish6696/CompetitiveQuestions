/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class KConcat
{
	public static void main (String[] args) throws java.lang.Exception
	{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        for(int i=0;i<test;i++){
            String[] input1=br.readLine().split(" ");
            int n=Integer.parseInt(input1[0]);
            int k=Integer.parseInt(input1[1]);
            String[] input2=br.readLine().split(" ");
            int[] ar=new int[n];
            for(int j=0;j<ar.length;j++){
                ar[j]=Integer.parseInt(input2[j]);
            }
            System.out.println(kConcat(ar,k));
        }


	}
	
    public static long kConcat(int[] ar,int k){
        return k==1?kadanes(ar):(sum(ar)>0?(getSuffixSum(ar)+(k-2)*sum(ar)+getPreffixSum(ar)):Math.max(getSuffixSum(ar)+getPreffixSum(ar),kadanes(ar)));
    }
    public static long sum(int[] ar){
        long sum=0;
        for(int val:ar){
            sum+=val;
        }
        return sum;
    }
    public static long kadanes(int[] ar){
        long cmax=0;
        long omax=Integer.MIN_VALUE;
        for(int val:ar){
            cmax=cmax>0?(cmax+val):val;
            omax=omax>cmax?omax:cmax;
        }
        return omax;
    }
    public static long getSuffixSum(int[] ar){
        long omax=Integer.MIN_VALUE;
        long cmax=0;
        for(int i=ar.length-1;i>=0;i--){
            cmax+=ar[i];
            omax=omax>cmax?omax:cmax;
        }
        return omax;
    }
    public static long getPreffixSum(int[] ar){
        long cmax=0;
        long omax=Integer.MIN_VALUE;
        for(int val:ar){
            cmax+=val;
            omax=omax>cmax?omax:cmax;
        }
        return omax;
    }
}
