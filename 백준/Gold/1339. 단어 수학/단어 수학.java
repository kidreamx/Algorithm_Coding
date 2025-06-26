import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static List<char[]> chars;
    static int[] alpha;
    static int sum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        calculate();
        System.out.println(sum);
    }
    static void input(BufferedReader br) throws IOException{
        N = Integer.parseInt(br.readLine());
        alpha = new int[26];
        chars = new ArrayList<>();

        for(int i=0;i<N;i++){
             chars.add(br.readLine().toCharArray());
        }
    }
    static void calculate(){
        // 가중치 계산
        for(int i=0;i<N;i++){
            for(int j=0;j<chars.get(i).length;j++){
                alpha[chars.get(i)[j]-'A'] += Math.pow(10,chars.get(i).length-1-j);
            }
        }
        Arrays.sort(alpha);
        int num = 9;
        int i = alpha.length-1;
        sum=0;
        while(alpha[i]!=0){
            sum += alpha[i]*num;
            num--;
            i--;
        }
    }
}