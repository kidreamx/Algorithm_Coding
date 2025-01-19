    import java.io.*;
    import java.util.*;


    public class Main {


        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());
            int num = 9;
            int[] alpha = new int[26];
            String[] sa = new String[N];
            for(int i=0;i<N;i++){
                sa[i] = br.readLine();
                int temp = (int)Math.pow(10,sa[i].length()-1);
                for(int j=0;j<sa[i].length();j++){
                    char c = sa[i].charAt(j);
                    alpha[c-'A'] +=temp;
                    temp/=10;
                }
            }
            Arrays.sort(alpha);
            int index = 25;
            int sum=0;
            while(alpha[index]!=0){
                sum += alpha[index] * num;
                num--;
                index--;
            }
            bw.write(sum+"");
            bw.flush();
            bw.close();

        }

    }
