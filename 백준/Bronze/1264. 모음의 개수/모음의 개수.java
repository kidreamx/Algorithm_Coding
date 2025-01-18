import java.io.*;

public class Main {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "";
        int count=0;
        while(true){
            s = br.readLine();
            if(s.equals("#")){
                break;
            }
            char[] chars = s.toCharArray();
            for(int i=0;i<s.length();i++){
                if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u' || chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U'){
                    count++;
                }

            }
            bw.write(count +"\n");
            count = 0;
        }
        br.close();
        bw.flush();
        bw.close();
    }


}
