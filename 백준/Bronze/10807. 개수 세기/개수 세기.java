import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] sa = br.readLine().split(" ");
        int v = Integer.parseInt(br.readLine());
        int count=0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(sa[i]);
            if(arr[i]==v)
            {
                count++;
            }
        }
        bw.write(count+"");
        br.close();
        bw.flush();
        bw.close();
    }


}
