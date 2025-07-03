import java.util.*;
import java.io.*;
public class Main{
    static int N;
    static StringBuilder sb;
    static int[][] coin;
    static boolean[] dp;
    static int sum;
    static final int MAX =  987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for(int t=0;t<3;t++){
            input(br);
            if(sum % 2 == 1) {
                sb.append(0+"\n");
                continue;
            }
            calculate();
            int target = sum / 2;
            if (dp[target])
                sb.append(1+"\n");
            else
                sb.append(0+"\n");
        }
        System.out.println(sb);
    }
    static void input(BufferedReader br) throws IOException{
        N = Integer.parseInt(br.readLine());
        coin = new int[N][2];
        dp = new boolean[100001];
        sum=0;
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            int weight = Integer.parseInt(sa[0]);
            int cnt = Integer.parseInt(sa[1]);
            coin[i][0] = weight;
            coin[i][1] = cnt;
            sum += weight*cnt;

        }
    }
    static void calculate(){
        dp[0] =true;
        for(int i=0;i<N;i++){
            for(int j= sum/2;j>=coin[i][0];j--){
                if(dp[j-coin[i][0]]){
                    for(int k=0;k<coin[i][1];k++){
                        dp[j+coin[i][0]*k] = true;
                    }
                }
            }
        }
    }
}