import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] sum = new int[5];
        int[][] arr = new int[5][4];
        int max = 0;
        int max_index=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                arr[i][j] = scanner.nextInt();
                sum[i] += arr[i][j];
            }
            if(sum[i]>max){
                max = sum[i];
                max_index= i;
            }
        }
        bw.write(max_index+1 +" "+max );
        scanner.close();
        bw.flush();
        bw.close();
    }


}
