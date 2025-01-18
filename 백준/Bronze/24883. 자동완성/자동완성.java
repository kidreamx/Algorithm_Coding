import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char a = br.readLine().charAt(0);
        if(a == 'N' || a == 'n'){
            bw.write("Naver D2\n");
        }
        else{
            bw.write("Naver Whale\n");
        }


        bw.flush();
        bw.close();

    }

}

