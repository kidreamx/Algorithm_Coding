import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        double sum=0.0;
        double under=0.0;
        for(int i=0;i<20;i++){

            String[] sa = br.readLine().split(" ");
            String s = sa[0];
            double score_1= Double.parseDouble(sa[1]);
            String s2 = sa[2];
            if(s2.equals("A+")){
                sum += score_1*4.5;
                under += score_1;
            }
            else if(s2.equals("A0")){
                sum += score_1*4.0;
                under += score_1;
            }
            else if(s2.equals("B+")){
                sum += score_1*3.5;
                under += score_1;
            }
            else if(s2.equals("B0")){
                sum += score_1*3.0;
                under += score_1;
            }
            else if(s2.equals("C+")){
                sum += score_1*2.5;
                under += score_1;
            }
            else if(s2.equals("C0")){
                sum += score_1*2.0;
                under += score_1;
            }
            else if(s2.equals("D+")){
                sum += score_1*1.5;
                under += score_1;
            }
            else if(s2.equals("D0")){
                sum += score_1*1.0;
                under += score_1;
            }
            else if(s2.equals("F")){
                sum += score_1*0.0;
                under += score_1;
            }


        }
        System.out.printf("%.6f",sum/under);
        br.close();
        bw.flush();
        bw.close();
    }


}
