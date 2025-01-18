import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        char[] chars = s.toCharArray();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(chars[i]=='a' || chars[i]=='e' || chars[i]=='i' || chars[i]=='o' || chars[i]=='u'){
                count++;
            }
        }
        bw.write(count+"");
        br.close();
        bw.flush();
        bw.close();
    }
}