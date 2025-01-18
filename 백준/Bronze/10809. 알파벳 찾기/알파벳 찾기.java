import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();
        int[] num = new int[26];
        Arrays.fill(num, -1);
        for(int i = 0; i < chars.length; i++){
            if(num[chars[i]-'a'] != -1){
                continue;
            }
            num[chars[i]-'a'] = i;
        }
        for(int i = 0; i < 26; i++){
            bw.write(num[i]+" ");
        }

        bw.flush();
        bw.close();

    }

}

