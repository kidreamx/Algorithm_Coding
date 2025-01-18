import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 면적당 참외 개수
        int[][] line = new int[6][2];
        for(int i=0;i<6;i++){
            String[] sa  = br.readLine().split(" ");
            line[i][0] = Integer.parseInt(sa[0]);
            line[i][1] = Integer.parseInt(sa[1]);
        }
        int max_under = Integer.MIN_VALUE ,under_index=0, max_side = Integer.MIN_VALUE,side_index=0;
        for(int i=0;i<6;i++){
            if(line[i][0]==1 || line[i][0]==2){
                if(max_side<line[i][1]){
                    max_side = line[i][1];
                    side_index = i;
                }
            }
            else{
                if(max_under<line[i][1]){
                    max_under = line[i][1];
                    under_index = i;
                }
            }
        }
        int min_under,min_side;
        if(side_index==5){
            min_side = Math.abs(line[side_index-1][1]-line[0][1]);
        }
        else if(side_index==0){
            min_side = Math.abs(line[side_index+1][1]-line[5][1]);
        }
        else{
            min_side = Math.abs(line[side_index+1][1]-line[side_index-1][1]);
        }
        if(under_index==5){
            min_under = Math.abs(line[under_index-1][1]-line[0][1]);
        }
        else if(under_index==0){
            min_under = Math.abs(line[under_index+1][1]-line[5][1]);
        }
        else{
            min_under = Math.abs(line[under_index+1][1]-line[under_index-1][1]);
        }
        System.out.println(N*(max_side*max_under - min_side*min_under));
    }
}
