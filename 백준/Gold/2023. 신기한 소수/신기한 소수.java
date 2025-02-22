import java.util.*;
import java.io.*;

public class Main{
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0,0);

    }
    static void dfs(int depth, int out){
        if(depth == N){
//            int sum=out[0];
//            if(!isPrime(sum)) return;
//            for(int i=1;i<N;i++){
//                sum*=10;
//                sum+= out[i];
//                if(!isPrime(sum)) return;
//            }
//            System.out.println(sum);
            System.out.println(out);
            return;
        }
        for(int i=1;i<=9;i++){
            int tmp = out;
            tmp *=10;
            tmp += i;
            if(!isPrime(tmp)) {
                continue;
            }else{
                dfs(depth+1,tmp);
            }
        }
    }
    static boolean isPrime(int N){
        if(N==2){
            return true;
        }
        else if(N==1){
            return false;
        }
        for(int i=2;i<=N/2;i++){
            if(N%i==0){
                return false;
            }
        }
        return true;
    }
}