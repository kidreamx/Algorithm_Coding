import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] chars = new char[5][15];
        for(int i=0;i<5;i++){
            chars[i] = br.readLine().toCharArray();
        }
        for(int i=0;i<15;i++){
            for(int j=0;j<5;j++){
                if(i>=chars[j].length){
                    continue;
                }
                System.out.print(chars[j][i]);
            }
        }


    }
}

