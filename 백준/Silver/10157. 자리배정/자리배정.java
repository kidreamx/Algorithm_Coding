import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int maxRow , maxCol , minRow=1, minCol=1;
    static int start_row=1 , start_col=1;
    static int K, std=0;
    static boolean isOutOfBound=false;
    public static void main(String[] args) throws IOException {
        init();
        findNum();
    }
    static void init() throws IOException{
        String[] input = br.readLine().split(" ");
        maxCol = Integer.parseInt(input[0]);
        maxRow = Integer.parseInt(input[1]);
        K = Integer.parseInt(br.readLine());
    }
    static void findNum(){
        while(K-->1){
            if(std ==0){
                if(start_row==maxRow-1){
                    start_row++;
                    std++;
                }
                else {
                    start_row++;
                }
            }else if(std ==1){
                if(start_col ==maxCol-1){
                    start_col++;
                    std++;
                }else{
                    start_col++;
                }

            }else if(std == 2){
                if(minRow+1 == start_row){
                    start_row--;
                    std++;
                }else{
                    start_row--;
                }

            }else if(std== 3){
                if(minCol+1 == start_col){
                    start_row++;
                    maxCol--;
                    maxRow--;
                    minRow++;
                    minCol++;
                    std=0;
                }else{
                    start_col--;
                }

            }
            if(is_out_of_bound()){
                isOutOfBound=true;
                break;
            }

        }
        if(!isOutOfBound) System.out.println(start_col+" "+start_row);
        else System.out.println(0);
    }
    static boolean is_out_of_bound(){
        if(start_row >maxRow|| start_col > maxCol){
            return true;
        }
        else {
            return false;
        }
    }
}