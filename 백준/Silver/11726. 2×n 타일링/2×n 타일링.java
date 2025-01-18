
import java.io.*;
import java.util.*;
public class Main{
    static int[][] arr;
    static int combination (int n, int k){
        if (arr[n][k] != 0) return arr[n][k];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<=i && j!=k+1;j++ ){
                if(i==j || j==0) arr[i][j] = 1;
                else arr[i][j] = (arr[i-1][j-1] + arr[i-1][j])%10007;
            }
        }
        return arr[n][k];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        int result=0;
        for(int i=N;i>0;i--){
            if(i>=N-i) {
                result += combination(i, N - i);
            }
        }
        bw.write(result%10007+"");
        bw.flush();
        bw.close();
    }
}
