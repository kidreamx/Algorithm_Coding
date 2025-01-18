import java.io.*;

public class Main {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int X = Integer.parseInt(br.readLine());
        int count=0;
        int start = 64;
        while(start>0){
            if(start>=X){
                if(X!=64) {
                    if (start / 2 > X) {
                        start = start / 2;
                    } else if (start / 2 == X) {
                        count++;
                        break;
                    } else {
                        X = X - start / 2;
                        start = start / 2;
                        count++;
                    }
                }
                else{
                    count++;
                    break;
                }
            }

        }
        bw.write(count+"");
        br.close();
        bw.flush();
        bw.close();
    }


}
