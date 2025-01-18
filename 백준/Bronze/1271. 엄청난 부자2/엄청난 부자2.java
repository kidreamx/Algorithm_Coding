import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BigInteger i = scanner.nextBigInteger();
        BigInteger j = scanner.nextBigInteger();
        bw.write(i.divide(j)+"\n");
        bw.write(i.remainder(j)+"\n");
        scanner.close();
        bw.flush();
        bw.close();
    }


}
