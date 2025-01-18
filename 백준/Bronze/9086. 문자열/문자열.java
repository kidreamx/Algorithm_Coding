import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String s = br.readLine();
            char[] chars = s.toCharArray();
            bw.write(chars[0]+""+chars[s.length()-1]+"\n");
        }
        bw.flush();
        bw.close();

    }

}

