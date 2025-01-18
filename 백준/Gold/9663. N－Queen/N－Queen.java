import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] chess;
    static int result;
    static List<Point> queue;
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        chess = new int[N];
        result=0;

        dfs(0);
        bw.write(result+"");
        br.close();
        bw.flush();
        bw.close();
    }
    public static void dfs(int col){
        if(col == N){
            result++;
            return;
        }
        for(int i=0;i<N;i++){
            chess[col] = i;
            if(possible(col)){
                dfs(col+1);
            }
        }
    }
    public static boolean possible(int col){
        for(int i=0;i<col;i++){
            if(chess[col] == chess[i]){
                return false;
            }
            else if(Math.abs(col-i) == Math.abs(chess[col]-chess[i])){
                return false;
            }

        }
        return true;
    }


}