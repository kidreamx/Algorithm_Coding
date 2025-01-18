import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long sum_a=0, sum_b=0;
        long[] x = new long[N];
        long[] y = new long[N];
        String result;
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            x[i] = Integer.parseInt(sa[0]);
            y[i] = Integer.parseInt(sa[1]);
        }
        for(int i=0;i<N;i++){
            if(i==N-1){
                sum_a+= x[i]*y[0];
                sum_b+= x[0]*y[i];
            }
            else {
                sum_a += x[i] * y[i + 1];
                sum_b += x[i + 1] * y[i];
            }
        }
        result = String.format("%.1f",(Math.abs(sum_a-sum_b))/2.0);
        bw.write(result);
        br.close();
        bw.flush();
        bw.close();

    }

}
