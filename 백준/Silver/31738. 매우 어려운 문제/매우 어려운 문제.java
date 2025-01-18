import java.io.*;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        long N = Long.parseLong(sa[0]);
        long M = Long.parseLong(sa[1]);
        long result=1;
        if(M<=N){
            result = 0;
        }
        else {
             for(long i = N;i>0;i--){
                 result *= i;
                 result %= M;
                 if(result == 0){
                     break;
                 }
             }

        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }


}
