import java.io.*;

public class Main {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String s = "int";
        String loop = new String();
        for(int i=0;i<N/4;i++){
           loop = loop.concat("long ");
        }
        String result = loop + s;
        bw.write(result);
        br.close();
        bw.flush();
        bw.close();
    }


}
