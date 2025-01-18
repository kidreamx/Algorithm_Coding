import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           int N = Integer.parseInt(br.readLine());
           while(N!=-1) {
               int[] arr = new int[N + 1];
               int sum = 0;
               int count = 0;
               for (int i = 1; i <= (N / 2); i++) {
                   if ((N % i) == 0) {
                       arr[i] = 1;
                       sum += i;
                       count++;
                   }
               }
               if (N == sum) {
                   bw.write(N + " = ");
                   for (int i = 1; i <= N / 2; i++) {
                       if (arr[i] == 1) {
                           if (count == 1) {
                               bw.write(i + "");

                           } else {
                               bw.write(i + " + ");
                               count--;
                           }
                       }

                   }
                   bw.write("\n");
               } else {
                   bw.write(N + " is NOT perfect." + "\n");
               }
               N = Integer.parseInt(br.readLine());
           }

        br.close();
        bw.flush();
        bw.close();
    }


}
