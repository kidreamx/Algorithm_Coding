import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] chars = s.toCharArray();
        int sum=0;
        for(int i=0;i<N;i++){
            sum += Character.getNumericValue(chars[i]);
        }
        bw.write(sum+"");
        br.close();
        bw.flush();
        bw.close();

    }

}
