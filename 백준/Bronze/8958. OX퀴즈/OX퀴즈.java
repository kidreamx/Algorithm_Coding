import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] chars = s.toCharArray();
            int zero_count = 0;
            int result=0;
            for(int j = 0; j < chars.length; j++) {
                if(chars[j] == 'O') {
                    zero_count++;
                    result += zero_count;
                }
                else if(chars[j] == 'X') {
                    zero_count = 0;
                }
            }
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();

    }

}

