import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] exp = new int[N+1];
        int[] num = new int[8];
        int[] dp = new int[256];
        int[][] dp2 = new int[256][2];
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<=7;i++){
            num[i] = i;
        }
        for(int i=0;i<N;i++){
            exp[i] = Integer.parseInt(sa[i]); // 로봇이 읽은 명령들
        }

        for(int i=0;i<7;i++){
            for(int j=i+1;j<=7;j++){
                dp[(int)Math.pow(2,i)+(int)Math.pow(2,j)] =1;
                dp2[(int)Math.pow(2,i)+(int)Math.pow(2,j)][0] = i;
                dp2[(int)Math.pow(2,i)+(int)Math.pow(2,j)][1] = j;
            }
        }
        for(int i=0;i<N;i++){
            if(dp[exp[i]]==1){
                int tmp = num[dp2[exp[i]][0]];
                num[dp2[exp[i]][0]] = num[dp2[exp[i]][1]];
                num[dp2[exp[i]][1]] = tmp;
            }

        }
        int K = Integer.parseInt(br.readLine());
        bw.write(num[K]+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
}

