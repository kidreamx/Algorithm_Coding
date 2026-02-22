import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        long K = Integer.parseInt(sa[1]);
        long remain = 1%K;
        long limit = 10;
        long standard = 10;
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<=N;i++){
            if(i == limit){
                limit *= 10;
                standard *= 10;
            }
           remain  = (remain*standard+i)%K;
        }

        System.out.println(remain);
    }
}