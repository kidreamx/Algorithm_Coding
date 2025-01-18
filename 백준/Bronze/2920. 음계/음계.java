import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] sa = br.readLine().split(" ");
        int[] music = new int[8];
        for(int i=0;i<8;i++){
            music[i]=Integer.parseInt(sa[i]);
        }
        int ascending =0;
        int descending =0;
        for(int i=0;i<8;i++){
            if(music[i]==i+1){
                ascending++;
            }
            else if(music[i] == 8-i){
                descending++;
            }
        }
        if(ascending==8){
            bw.write("ascending");
        }
        else if(descending==8){
            bw.write("descending");
        }
        else{
            bw.write("mixed");
        }

        bw.flush();
        bw.close();

    }

}

