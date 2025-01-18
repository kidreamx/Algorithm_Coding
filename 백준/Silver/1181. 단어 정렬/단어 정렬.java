import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        for(int i=0;i<N;i++){
            strings[i] = br.readLine();
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return  o1.compareTo(o2);
                }
                else{
                    return o1.length() - o2.length();
                }
            }
        });
        bw.write(strings[0]+"\n");
        for(int i=1;i<N;i++){
            if(!strings[i].equals(strings[i-1])){
                bw.write(strings[i]+"\n");
            }

        }
        br.close();
        bw.flush();
        bw.close();
    }
}