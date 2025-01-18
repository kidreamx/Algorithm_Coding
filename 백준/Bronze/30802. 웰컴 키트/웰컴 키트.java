import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        int[] shirt = new int[6];
        int shirt_result=0;
        for (int i = 0; i < 6; i++) {
            shirt[i] = Integer.parseInt(sa[i]);
        }
        sa = br.readLine().split(" ");
        int T = Integer.parseInt(sa[0]);
        int P = Integer.parseInt(sa[1]);
        for(int i=0 ; i<6;i++){
            if(shirt[i]%T ==0 ){
                shirt_result += shirt[i]/T;
            }
            else {
                shirt_result += shirt[i] / T + 1;
            }
        }
        bw.write(shirt_result+"\n");
        bw.write(N/P +" "+ N%P+"\n");


        bw.flush();
        bw.close();

    }

}

