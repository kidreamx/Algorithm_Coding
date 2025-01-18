import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int X = Integer.parseInt(sa[1]);
        int[] arr = new int[N];
        sa = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            if(Integer.parseInt(sa[i])<X){
                bw.write(Integer.parseInt(sa[i])+" ");
            }
        }
        bw.flush();
        bw.close();
    }


}
