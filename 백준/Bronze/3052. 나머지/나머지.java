import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[10];
        int[] count = new int[1001];
        int result=0;
        for(int i = 0; i < 10; i++){
            num[i] = Integer.parseInt(br.readLine());
            count[num[i]%42]++;
        }
        for(int i=0;i<1001;i++){
            if(count[i]>=1){
                result++;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();

    }

}

