import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(s, i+1);
            map2.put(i+1, s);
        }
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if(map.containsKey(s)) {
                bw.write(map.get(s)+"\n");
            }
            else{
                int num = Integer.parseInt(s);
                bw.write(map2.get(num)+"\n");
            }
        }
        bw.flush();
        bw.close();

    }

}

