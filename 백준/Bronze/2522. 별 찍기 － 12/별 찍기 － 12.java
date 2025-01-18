import java.io.*;

public class Main {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            for(int j=i;j<N-1;j++){
                bw.write(" ");
            }
            for(int k=N;k>=N-i;k--){
                bw.write("*");
            }
            bw.write("\n");
        }
        for(int i=0;i<N-1;i++){
            for(int j=N;j>=N-i;j--){
                bw.write(" ");
            }
            for(int k=i;k<N-1;k++){
                bw.write("*");
            }
            bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }


}
