import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);
        int[] dp = new int[N];
        int result=0;
        for(int i=0;i<N;i++) {
            result += arr[i];
            dp[i] = result;
        }
        result = 0;
        for(int i=0;i<N;i++) {
            result+= dp[i];
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}
