import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] example = new int[N];
        int sum =0;
        String[] sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            example[i] = Integer.parseInt(sa[i]);
            sum+= example[i];
        }
        Arrays.sort(example);
        int test_num =1;
        int small = 1;
        for(int i=0;i<N;i++){
            if(example[i]>small){
                break;
            }
            small += example[i];
        }

        bw.write(small+"");
        br.close();
        bw.flush();
        bw.close();
    }
}