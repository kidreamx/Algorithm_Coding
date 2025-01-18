import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int K = Integer.parseInt(sa[0]);
        int N = Integer.parseInt(sa[1]);
        int M = Integer.parseInt(sa[2]);
        if(K*N>M){
            bw.write(K*N-M+"");
        }
        else{
            bw.write(0+"");
        }
        br.close();
        bw.flush();
        bw.close();

    }

}
