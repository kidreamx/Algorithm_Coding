import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] sa = br.readLine().split(" ");
        double[] num = new double[N];
        double num1=0;
        double max=0;
        for(int i=0;i<N;i++){
            if(Double.parseDouble(sa[i])>max){
                max=Double.parseDouble(sa[i]);
            }
            num[i]=Double.parseDouble(sa[i]);
        }
        for(int i=0;i<N;i++){
            num[i]=num[i]/max*100;
            num1+=num[i];
        }
        bw.write(num1/N+"");
        bw.flush();
        bw.close();

    }

}

