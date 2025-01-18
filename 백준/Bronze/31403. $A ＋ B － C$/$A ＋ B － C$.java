import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        bw.write(A+B-C+"\n");
        String s1 = Integer.toString(A);
        String s2 = Integer.toString(B);
        int AB = Integer.parseInt(s1.concat(s2));
        bw.write(AB-C+"");


        bw.flush();
        bw.close();

    }

}

