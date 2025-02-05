import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] num;
    static boolean[] visited;
    static boolean is_given = false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        int[] result = new int[N];
        dfs(0,result ,0);
        if(!is_given){
            System.out.println("NO");
        }
    }
    static boolean isPrimeNum(int N){
        if(N==1){
            return true;
        }
        for(int i=2;i<=N/2;i++){
            if(N%i==0){
                return true;
            }
        }
        return false;
    }
    static void dfs(int sum, int[] out, int depth){
        if(!isPrimeNum(sum) && sum !=0){
            return;
        }
        if(depth==N){
            if(is_given){
                return;
            }
            is_given = true;
            System.out.println("YES");
            for(int i=0;i<N;i++){
                System.out.print(out[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1 ; i<= N; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            out[depth] = i;
            dfs(sum+i,out,depth+1);
            if(is_given){
                break;
            }
            visited[i] = false;

        }
    }
}