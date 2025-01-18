import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa= br.readLine().split(" ");
        int first = Integer.parseInt(sa[0]);
        int second = Integer.parseInt(sa[1]);
        int max = 0;
        for(int i=1;i<=first;i++){
            if(i>second){
                break;
            }
            if(first%i==0 && second%i==0){
                if(max<i){
                    max = i;
                }
            }
        }
        bw.write(max+"\n");
        bw.write(max*(second/max)*(first/max)+"\n");
        bw.flush();
        bw.close();

    }

}

