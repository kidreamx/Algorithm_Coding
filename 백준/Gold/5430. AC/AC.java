import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        int[] arr;
        for(int i=0;i<T;i++){
            int Rcount=0;
            int Dcount=0;
            Deque<Integer> deque = new ArrayDeque<>();
            String s = br.readLine();
            String[] s2 = s.split("");
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            String t = br.readLine();
            if(t.length()>2){
                String[] sa = t.substring(1, t.length() - 1).split(",");
                for (int k = 0; k < sa.length; k++) {
                    deque.addLast(Integer.parseInt(sa[k]));
                }
            }
            for(int k=0;k<s.length();k++){
                if(s2[k].equals("R")){
                    if(Rcount == 0 ){
                        Rcount = 1;
                    }
                    else{
                        Rcount=0;
                    }
                }
                else if(s2[k].equals("D")){
                    if(!deque.isEmpty()) {
                        if (Rcount == 0) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    }
                    Dcount++;
                }
            }
            if(Dcount==0 && n==0){
                bw.write("[]"+"\n");
                continue;
            }
            else if(Dcount>n){
                bw.write("error"+"\n");
                continue;
            }

            bw.write("[");
            int r=0;
            while(!deque.isEmpty()){
                if(Rcount==1) {
                    if(r==0)
                        bw.write(Integer.toString(deque.pollLast()));
                    else if(r==n-1)
                        bw.write(","+Integer.toString(deque.pollLast()));
                    else
                        bw.write(","+Integer.toString(deque.pollLast()));
                }
                else{
                    if(r==0)
                        bw.write(Integer.toString(deque.pollFirst()));
                    else if(r==n-1)
                        bw.write(","+Integer.toString(deque.pollFirst()));
                    else
                        bw.write(","+Integer.toString(deque.pollFirst()));
                }
                r++;
            }
            bw.write("]"+"\n");


        }
        bw.flush();
        bw.close();


    }

}
