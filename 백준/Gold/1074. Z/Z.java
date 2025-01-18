import java.util.*;
import java.io.*;

class Main{

    static int N,r,c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        r = Integer.parseInt(sa[1]);
        c = Integer.parseInt(sa[2]);
        int sibal = (int)Math.pow(2,N);
        han_num(sibal,0,0, 0);

    }
    public static void han_num(int N,int row, int col, int count){
        int pivot =N/2;
        if(row==r && col == c){
            System.out.println(count);
            return;
        }
        if(pivot>=1){
            if(r<row+pivot){
                if(c<col+pivot){ // 1분면
                    han_num(pivot,row,col,count);
                }
                else{ // 2분면
                    count+= (N*N)/4;
                    han_num(pivot,row, col+pivot,count);
                }
            }
            else{
                if(c<col+pivot){ // 3분면
                    count+= ((N*N)/4)*2;
                    han_num(pivot,row+pivot, col,count);
                }
                else{ // 4분면
                    count+= ((N*N)/4)*3;
                    han_num(pivot, row+pivot, col+pivot,count);
                }
            }

        }


    }
}