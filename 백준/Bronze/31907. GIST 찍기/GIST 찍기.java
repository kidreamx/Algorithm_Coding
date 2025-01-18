import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] line = {"G...",".I.T","..S."};

        for(int i=0;i<3;i++){
            for(int r=0;r<N;r++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < N; k++) {
                        bw.write(line[i].charAt(j));
                    }
                }
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}