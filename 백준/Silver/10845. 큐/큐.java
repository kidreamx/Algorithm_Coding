import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int last=0;
        for(int i = 0; i < N; i++) {
            String[] sa = br.readLine().split(" ");
            if(sa[0].equals("push")) {
                last = Integer.parseInt(sa[1]);
                q.add(Integer.parseInt(sa[1]));

            }
            else if(sa[0].equals("pop")) {
                if(q.isEmpty()){
                    bw.write("-1\n");
                }
                else{
                    bw.write(q.remove()+"\n");
                }
            }
            else if(sa[0].equals("size")) {
                bw.write(q.size()+"\n");
            }
            else if(sa[0].equals("empty")) {
                if(q.isEmpty()){
                    bw.write("1\n");
                }
                else{
                    bw.write("0\n");
                }
            }
            else if(sa[0].equals("front")) {
                if(q.isEmpty()){
                    bw.write("-1\n");
                }
                else{
                    bw.write(q.peek()+"\n");
                }
            }
            else if(sa[0].equals("back")) {
                if(q.isEmpty()){
                    bw.write("-1\n");
                }
                else {
                    bw.write(last + "\n");
                }
            }
        }
        bw.flush();
        bw.close();

    }

}

