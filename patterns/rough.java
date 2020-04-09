import java.util.ArrayList;
import java.util.Arrays;
public class rough {
public static void main(String[] args) {
    
    int [][] arr ={{8,7,3,4},{1,2,3,6},{5,1,8,9},{3,4,2,5}};
    int rows =0;
    int rowe= arr.length-1; 
    int cols = 0;
    int cole = arr[0].length-1;
    int k =2;
    
    while(rows<=rowe&&cols<=cole){
        int x =rows;
        int y =cols;
        ArrayList<Integer> list = new ArrayList<>();
        
        
        //dir ==1;
        while(y<=cole){
            list.add(arr[x][y]);
            y++;
        }
        //dir 2
        x = rows+1;
        y= cole;
        while(x<=rowe){
            list.add(arr[x][y]);
            x++;
        }
        
        //dir 3
        y =cole-1;
        x= rowe;
        while(y>=cols){
            list.add(arr[x][y]);
            y--;
        }
        //dir 4
        x=rowe-1;
        y=cols;
        while(x>rows){
            list.add(arr[x][y]);
            x--;
        } 
        
        
        x =rows;
        y =cols;
        int idx =k;
      
        //dir ==1;
        while(y<=cole){
            k=k%list.size();
            arr[x][y]=list.get(k);
            k++;
            y++;
        }
        //dir 2
        x = rows+1;
        y= cole;
        while(x<=rowe){
            k=k%list.size();
            arr[x][y]=list.get(k);
            k++;
            x++;
        }
        
        //dir 3
        y =cole-1;
        x= rowe;
        while(y>=cols){
            k=k%list.size();
            arr[x][y]=list.get(k);
            k++;
            y--;
        }
        //dir 4
        x=rowe-1;
        y=cols;
        while(x>rows){
            k=k%list.size();
            arr[x][y]=list.get(k);
            k++;
            x--;
        }
        
        rows++;
        rowe--;
        cols++;
        cole--;
    }


    for (int i = 0; i < arr.length; i++) {
        System.out.println(Arrays.toString(arr[i]));
    }
}
}