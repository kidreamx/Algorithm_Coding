import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s= br.readLine();
        System.out.println(s.length());
//        String[] sa = br.readLine().split(" ");
//        int N = Integer.parseInt(sa[0]);
//        int M = Integer.parseInt(sa[1]);
//        char[][] arr = new char[N+1][M+1];
//        for(int i=1;i<=N;i++){
//            char[] ch = br.readLine().toCharArray();
//            for(int j=1;j<=M;j++){
//                arr[i][j] = ch[j-1];
//            }
//        }

        bw.flush();
        bw.close();

    }

}

