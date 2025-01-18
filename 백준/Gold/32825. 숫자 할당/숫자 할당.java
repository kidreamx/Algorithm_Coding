import java.util.*;
import java.io.*;
public class Main{
    static int A,B,C,D,E,F,G,H,a,b,c,d,e,f,g,h,i,j,k,l,m;
    static boolean[] visited;
    static int count=0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        A = Integer.parseInt(sa[0]);
        B = Integer.parseInt(sa[1]);
        C = Integer.parseInt(sa[2]);
        D = Integer.parseInt(sa[3]);
        E = Integer.parseInt(sa[4]);
        F = Integer.parseInt(sa[5]);
        G = Integer.parseInt(sa[6]);
        H = Integer.parseInt(sa[7]);
        visited = new boolean[14];
        dfs(0);
        System.out.println(count);
    }
    static void dfs(int index){
        if(index == 2){
            if(H != l + m){
                return;
            }
        }
        else if(index == 4){
            if(D != d+h){
                return;
            }
        }
        else if(index == 7){
            if(G != i+j+k){
                return;
            }
        }
        else if(index == 9){
            if(C != c+g+k){
                return;
            }
        }
        else if(index == 11){
            if(F != e+f+g+h){
                return;
            }
        }
        else if(index == 12){
            if(B != b+f+j+m){
                return;
            }
        }
        else if(index == 13){
            if(A == a+e+i+l && E == a+b+c+d){
                count++;

            }
            return;
        }
        for(int p=1;p<=13;p++){
            if(visited[p]){
                continue;
            }
            visited[p] = true;
            if(index==0){
                l = p;
            }
            else if(index==1){
                m = p;
            }
            else if(index==2){
                d = p;
            }
            else if(index==3){
                h = p;
            }
            else if(index==4){
                i = p;
            }
            else if(index==5){
                j = p;
            }
            else if(index==6){
                k = p;
            }
            else if(index==7){
                c = p;
            }
            else if(index==8){
                g = p;
            }
            else if(index==9){
                e = p;
            }
            else if(index==10){
                f = p;
            }
            else if(index==11){
                b = p;
            }
            else if(index==12){
                a = p;
            }
            dfs(index+1);
            visited[p] = false;
        }
    }
}