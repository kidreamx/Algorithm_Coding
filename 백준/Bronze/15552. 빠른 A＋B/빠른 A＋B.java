import java.io.*;

public class Main {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String[] sa = br.readLine().split(" ");
            bw.write(Integer.parseInt(sa[0])+Integer.parseInt(sa[1])+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }


}
