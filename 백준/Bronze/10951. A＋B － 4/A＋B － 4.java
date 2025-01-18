import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while((s=br.readLine())!=null){
            String[] sa = s.split(" ");
            bw.write(Integer.parseInt(sa[0])+ Integer.parseInt(sa[1])+"\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }

}
