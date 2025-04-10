import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int [][]consult = new int[N+1][2];
        int []max = new int[N+1];
        int resultMax = 0;
        for(int i=1;i<=N;i++){
            String[] s = br.readLine().split(" ");
            consult[i][0] = Integer.parseInt(s[0]);
            consult[i][1] = Integer.parseInt(s[1]);
        }
        for(int i=N;i>=0;i--){
            int index= N;
            int middlecheck=0;
            if (consult[i][0] + i <= N + 1) {
                middlecheck += consult[i][1];
            }
            if(i==N){
                max[i] = middlecheck;
                resultMax = max[i];
            }
            else{
                if(middlecheck!=0 && i+ consult[i][0]<N+1){
                    max[i] = middlecheck+max[i+consult[i][0]];
                }
                else{
                    max[i] = middlecheck;
                }
                if(max[i]>resultMax){
                    resultMax =  max[i];
                }
                else{
                    max[i] = resultMax;
                }

            }

        }

        bw.write(Integer.toString(resultMax));
        bw.flush();
        bw.close();
    }


}
