import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] result = new int[N];
        Arrays.fill(result, 1);
        int max = 0;
        String[] sa = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }
        for(int i=1 ; i<N ; i++){
            max=0;
            for(int j=0; j<i;j++){
                if(arr[i]>arr[j]){
                    if(max<result[j]){
                        max = result[j];
                        result[i] = result[j]+1;
                    }
                }
            }
        }
        max=0;
        for(int i=0 ; i<N ; i++){
            if(max<result[i]){
                max = result[i];
            }
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();

    }

}

