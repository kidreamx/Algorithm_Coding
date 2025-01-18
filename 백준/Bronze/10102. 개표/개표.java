import java.io.*;

public class Main {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int V = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int a_cnt=0;
        int b_cnt=0;
        for(int i=0;i<V;i++){
            if(s.charAt(i)=='A'){
                a_cnt++;
            }
            else if(s.charAt(i)=='B'){
                b_cnt++;
            }
        }
        if(a_cnt == b_cnt){
            bw.write("Tie");
        }
        else if(a_cnt>b_cnt){
            bw.write("A");
        }
        else{
            bw.write("B");
        }
        br.close();
        bw.flush();
        bw.close();
    }


}
