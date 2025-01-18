import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] age = new int[N][2];
        String[] name = new String[N];
        for(int i = 0; i < N; i++) {
            String[] sa = br.readLine().split(" ");
            age[i][0] = Integer.parseInt(sa[0]);
            age[i][1] = i;
            name[i] = sa[1];
        }
        Arrays.sort(age, (o1, o2) -> {
            return o1[0]-o2[0];
        });
        for(int i = 0; i < N; i++) {
            bw.write(age[i][0] +" " +name[age[i][1]]+"\n");
        }
        bw.flush();
        bw.close();

    }

}

