import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int robot=0,box=0,arrive=0;
        String s = br.readLine();
        char[] chars = s.toCharArray();
        for(int i=0;i<10;i++){
            if(chars[i] == '@'){
                robot = i;
            }
            else if(chars[i] == '#'){
                box = i;
            }
            else if(chars[i] == '!'){
                arrive = i;
            }
        }
        if(robot < box && box < arrive) {
            bw.write(arrive - robot -1+"");
        }
        else if(arrive < box && box < robot)
        {
            bw.write(robot - arrive -1+"");
        }
        else{
            bw.write("-1");
        }
        br.close();
        bw.flush();
        bw.close();

    }

}
