import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa =  br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        int K = Integer.parseInt(sa[2]);
        int[][] chess = new int[N+1][M+1];
        boolean color = false;
        for(int i=1;i<=N;i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=1;j<=M;j++){
                if(!color && chars[j-1] == 'W'){
                    chess[i][j] = 1;
                }
                else if(color && chars[j-1] == 'B'){
                    chess[i][j] = 1;
                }
                color = !color;
            }
            if(M%2==0){
                color = !color;
            }
        }
        // 행 더하기
        for(int i=1;i<=N;i++){
            int temp= chess[i][1];
            for(int j=2;j<=M;j++){
                temp += chess[i][j];
                chess[i][j] = temp;
            }
        }
        //열 더하기
        for(int i=1;i<=M;i++){
            int temp = chess[1][i];
            for(int j=2;j<=N;j++){
                temp+= chess[j][i];
                chess[j][i] = temp;
            }
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=K;i<=N;i++){
            for(int j=K;j<=M;j++){
                int change = chess[i][j] - (chess[i-K][j] + chess[i][j-K]-chess[i-K][j-K]);
                max = Math.max(change,max);
                min = Math.min(change,min);
            }
        }
        int answer = Math.min(min,K*K-max);
        System.out.println(answer);

    }

}