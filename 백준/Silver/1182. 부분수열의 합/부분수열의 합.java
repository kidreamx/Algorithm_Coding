import java.io.*;
import java.util.*;


public class Main {
    static int N, S;
    static int[] arr;
    static int answer=0;
    static void dfs(int depth, int sum){
        if(depth == N){
            if(sum == S){
                answer++;
            }
            return;
        }
        dfs(depth+1, sum+arr[depth]);
        dfs(depth+1, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        S = Integer.parseInt(sa[1]);
        sa = br.readLine().split(" ");
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }
        dfs(0,0);
        if(S == 0){
            bw.write(answer-1+"");
        }
        else{
            bw.write(answer+"");
        }
        bw.flush();
        bw.close();

    }

}
