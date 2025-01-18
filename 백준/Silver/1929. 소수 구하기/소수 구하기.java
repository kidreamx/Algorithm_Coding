import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int start = Integer.parseInt(sa[0]);
        int end = Integer.parseInt(sa[1]);
        boolean[] check = new boolean[end+1];
        check[0] = true;
        check[1] = true;
        for(int i=2;i<=(end/2);i++){
           for(int j=2;i*j<=end;j++){
               check[i*j] = true;
           }
        }
        for(int i=start;i<=end;i++){
            if(!check[i]){
                bw.write(i+"\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();

    }

}
