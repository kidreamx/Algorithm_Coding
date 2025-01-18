import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int[][] arr = new int[N+1][N+1];
        int[][] line = new int[N+1][N+1];
        int sum=0;
        for(int i = 1; i <= N; i++){
            sa = br.readLine().split(" ");
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(sa[j-1]);
                line[i][j] = arr[i][j] + line[i-1][j];
            }
        }
        for(int i = 1; i <= M; i++){
            sa = br.readLine().split(" ");
            int start_x = Integer.parseInt(sa[0]);
            int start_y = Integer.parseInt(sa[1]);
            int end_x = Integer.parseInt(sa[2]);
            int end_y = Integer.parseInt(sa[3]);
            for(int j = start_y; j <= end_y; j++){
                if(start_x == 1){
                    sum+= line[end_x][j];
                }
                else{
                    sum+= line[end_x][j] - line[start_x-1][j];
                }
            }
            bw.write(sum+"\n");
            sum=0;
        }
        bw.flush();
        bw.close();

    }

}

