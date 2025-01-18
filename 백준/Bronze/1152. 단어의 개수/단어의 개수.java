import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count;
        String s = br.readLine();
        s = s.trim();
        String[] sa = s.split(" ");
        if(s.equals("")){
            count=0;
        }
        else if(s.equals(" ")){
            count=0;
        }
        else {
            count = sa.length;
        }
        bw.write(count+"");
        br.close();
        bw.flush();
        bw.close();

    }

}
