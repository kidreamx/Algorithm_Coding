import java.util.*;
import java.io.*;

class Main{
    static int[][] arr;
    static int N;
    static int white_paper =0, blue_paper=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }
        paper(N,0,0);
        System.out.println(white_paper);
        System.out.println(blue_paper);
    }
    static void paper(int size, int col, int row){
        if(size==1){
            if(arr[col][row]==1){
                blue_paper++;
            }
            else{
                white_paper++;
            }
            return;
        }
        boolean one_color=true;
        int standard_color;
        if(arr[col][row]==1){
            standard_color = 1;
        }
        else{
            standard_color=0;
        }
        for(int i=col;i<col+size;i++){
           for(int j=row;j<row+size;j++){
               if(arr[i][j]!=standard_color){
                   one_color=false;
                   break;
               }
           }
        }
        if(!one_color){
           paper(size/2,col,row);
           paper(size/2,col+size/2,row);
           paper(size/2,col+size/2,row+size/2);
           paper(size/2,col,row+size/2);
        }
        else{
            if(standard_color == 1){
                blue_paper++;
            }
            else{
                white_paper++;
            }
        }
    }
}