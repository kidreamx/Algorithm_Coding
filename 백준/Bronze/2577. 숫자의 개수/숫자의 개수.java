import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int result = A*B*C;
        String r = Integer.toString(result);
        int[] count = new int[10];
        for(int i=0;i<r.length();i++){
            int num = result%10;
            result = result/10;
            count[num]++;
        }
        for(int i=0;i<10;i++){
            bw.write(count[i]+"\n");
        }
        bw.flush();
        bw.close();

    }

}

