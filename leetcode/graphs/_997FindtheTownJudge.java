public class _997FindtheTownJudge{
    public static void main(String[] args) {
        int N =3;
        int [][] trust ={{1,3},{2,3}};
        System.out.println(findJudge(trust, N));
    }

    public static int findJudge(int [][] trust,int N ){
        int [] inDeegre =new int [N];
        int [] outDeegre=new int [N];
        for (int i = 0; i < trust.length; i++) {
            int a =trust[i][0];
            int b =trust[i][1];
            outDeegre[a-1]++;
            inDeegre[b-1]++;
        }

        for(int i=0;i<outDeegre.length;i++){
           if(outDeegre[i]==0 && inDeegre[i]==N-1){
            return i+1;
           }
        }
        return -1;
    }
}