import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] paper = new int[6];
        int minimum = 0;
        int remain;
        for(int i=0;i<6;i++){
            paper[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 5; i>=0;i--){

             if(i+1 == 6) {
                 if (paper[i] > 0) {
                     minimum += paper[i];

                 }
               
             }
             if(i+1 == 5) {
                 while (paper[i] > 0) {
                     paper[i]--;
                     minimum++;
                     paper[0] -= 11;

                 }

             }
             if(i+1 == 4) {
                 if (paper[i] > 0) {
                     while (paper[i] > 0) {
                         paper[i]--;
                         minimum++;
                         remain = 20;
                         if (paper[1] > 0) { // 2가 1개라도 있을때
                             if (paper[1] >= 5) {
                                 paper[1] -= 5;
                             } else { // 2*2가 5개 미만인 경우
                                 int second_num = paper[1];
                                 remain = remain - second_num * 4;
                                 if (remain > paper[0]) {
                                     paper[0] -= paper[0];
                                 } else {
                                     paper[0] -= remain;
                                 }
                                 paper[1] -= paper[1];
                             }
                         } else {
                             if (paper[0] >= 20) {
                                 paper[0] -= 20;
                             } else {
                                 paper[0] -= paper[0];
                             }
                         }
                     }
                 }

             }
             if(i+1 == 3) {
                 if (paper[i] > 0) {
                     while (paper[i] > 0) {
                         if (paper[i] >= 4) {
                             paper[i] -= 4;
                             minimum++;
                         } else {
                             if (paper[i] == 3) {
                                 remain = 9;  //4 - 2 , 1  remain = 9
                                 paper[i] -= 3;
                                 if (paper[1] > 0) { // 2가 1개라도 있을때
                                     if (paper[1] >= 1) {
                                         paper[1] -= 1;
                                         if (paper[0] >= 5) {
                                             paper[0] -= 5;
                                         } else {
                                             paper[0] -= paper[0];
                                         }
                                     }

                                 } else {
                                     if (paper[0] >= 9) {
                                         paper[0] -= 9;
                                     } else {
                                         paper[0] -= paper[0];
                                     }
                                 }
                                 minimum++;
                             } else if (paper[i] == 2) {
                                 remain = 18;  //4 - 4 , 1*2 ,   remain = 18
                                 paper[i] -= 2;
                                 if (paper[1] > 0) { // 2가 1개라도 있을때
                                     if (paper[1] >= 3) {
                                         paper[1] -= 3;
                                         if (paper[0] >= 6) {
                                             paper[0] -= 6;
                                         } else {
                                             paper[0] -= paper[0];
                                         }
                                     } else { // 2*2가 9개 미만인 경우
                                         int second_num = paper[1];
                                         remain = remain - second_num * 4;
                                         if (remain > paper[0]) {
                                             paper[0] -= paper[0];
                                         } else {
                                             paper[0] -= remain;
                                         }
                                         paper[1] -= paper[1];
                                     }
                                 } else {
                                     if (paper[0] >= 18) {
                                         paper[0] -= 18;
                                     } else {
                                         paper[0] -= paper[0];
                                     }
                                 }
                                 minimum++;
                             } else if (paper[i] == 1) {
                                 remain = 36 - paper[i] * 9;  //2 - 13 ,1 - 1 ,   remain = 27
                                 paper[i] -= 1;
                                 if (paper[1] > 0) { // 2가 1개라도 있을때
                                     if (paper[1] >= 5) {
                                         paper[1] -= 5;
                                         if (paper[0] >= 7) {
                                             paper[0] -= 7;
                                         } else {
                                             paper[0] -= paper[0];
                                         }
                                     } else { // 2*2가 13개 미만인 경우
                                         int second_num = paper[1];
                                         remain = remain - second_num * 4;
                                         if (remain > paper[0]) {
                                             paper[0] -= paper[0];
                                         } else {
                                             paper[0] -= remain;
                                         }
                                         paper[1] -= paper[1];
                                     }
                                 } else {
                                     if (paper[0] >= 27) {
                                         paper[0] -= 27;
                                     } else {
                                         paper[0] -= paper[0];
                                     }
                                 }
                                 minimum++;
                             }
                         }
                     }
                 }

             }
             if(i+1 == 2) {
                 while (paper[i] > 0) {
                     if (paper[1] >= 9) {
                         paper[1] -= 9;
                     } else { // 2*2가 9개 미만인 경우
                         remain = 36;
                         int second_num = paper[1];
                         remain = remain - second_num * 4;
                         if (remain > paper[0]) {
                             paper[0] -= paper[0];
                         } else {
                             paper[0] -= remain;
                         }
                         paper[1] -= paper[1];
                     }

                     minimum++;
                 }

             }
             if(i+1 == 1){
                    while(paper[i]>0){
                        if (paper[0] >= 36) {
                            paper[0] -= 36;
                        } else {
                            paper[0] -= paper[0];
                        }
                        minimum++;
                    }

            }

        }
        bw.write(minimum+"");
        bw.flush();
        bw.close();
    }


}
