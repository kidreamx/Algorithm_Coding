import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        char[] c = s.toCharArray();
        bw.write((int)c[0]+"");
        br.close();
        bw.flush();
        bw.close();

    }

}
