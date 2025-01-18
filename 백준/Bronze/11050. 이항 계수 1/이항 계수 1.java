import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int result=1;
        int divide=1;
        if(K==0){
            bw.write(1+"");
        }
        else{
            for(int i=N; i>N-K;i--){
                result *= i;
            }
            for(int i=1; i<=K;i++){
                divide *= i;
            }
            bw.write(result/divide + "");
        }

        bw.flush();
        bw.close();

    }

}

