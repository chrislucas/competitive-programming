package contest;


import java.io.*;
import java.util.StringTokenizer;

// https://www.hackerearth.com/algorithms-qualifiers-round-1/algorithm/hungry-lemurs/
/*
* https://www.hackerearth.com/algorithms-qualifiers-round-2/problems/
* https://www.hackerearth.com/algorithms-qualifiers-round-1/algorithm/strange-function/
* */
public class HungryLemurs {

    public static void main(String[] args) {
	    // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
        int n, k, auxn, auxk;
        try {
            StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
            n = Integer.parseInt(token.nextToken());         // banadas
            k = Integer.parseInt(token.nextToken());         // lemurs
            s2(writer, n, k);
        } catch(IOException ioex){}
    }

    public static void s2(PrintWriter writer, int n, int k) {
        boolean flag = true;
        int aux1, aux2, min;
        int acc[] = {0,Integer.MAX_VALUE,0,0,0,Integer.MAX_VALUE};
        if(n > k && n%k!=0) {
            acc[0] = n - k;
            acc[1] = k;
            for(int i=2; i<n; i++) {
                if(n % i== 0) {
                    int x = Math.abs((int)Math.floor(n/i-k));
                    acc[1] =  Math.min(x, acc[1]);//;
                }
            }
            aux1 = n;
            aux2 = k;
            while(aux1 % aux2 != 0) {
                if(flag)
                    aux1--;
                else
                    aux2++;
                acc[2]++;
                flag = !flag;
            }

            aux1 = n;
            aux2 = k;
            flag = true;
            while(aux1 % aux2 != 0) {
                if(flag)
                    aux1++;
                else
                    aux2--;
                acc[3]++;
                flag = !flag;
            }

            aux1 = n;
            aux2 = k;
            flag = true;
            while(aux1 % aux2 != 0) {
                if(flag)
                    aux1--;
                else
                    aux2--;
                acc[4]++;
                flag = !flag;
            }

/*
            aux1 = n;
            aux2 = k;
            flag = true;
            if(gdc(aux1, aux2) == 1) {
                acc[5] = Integer.MAX_VALUE;
            } else {
                while(aux1 % aux2 != 0) {
                    if(flag)
                        aux1++;
                    else
                        aux2++;
                    acc[5]++;
                    flag = !flag;
                }
            }
*/
            min = Math.min(acc[5], Math.min(acc[4], Math.min(acc[3], Math.min(acc[2], Math.min(acc[1], acc[0])))));
        } else if(k > n) {
            min = Math.min(n, k - n);
        } else {
           min = 0;
        }
        writer.printf("%d\n", min);
    }

    public static int gdc(int a, int b) {
        if(a%b==0)
            return b;
        else return gdc(b, a%b);
    }

    // old
    public static void s1(PrintWriter writer, int auxn, int auxk, int n, int k) {
        int ca = 0, cb = 0, cc = 0, cd = 0;
        boolean flag;

        if(n > k) {
            auxk = k;
            auxn = n;
            // diminuir
            while(auxn%auxk!=0) {
                auxn--;
                ca++;
            }

            auxk = k;
            auxn = n;
            while(auxn%auxk!=0) {
                auxk++;
                cb++;
            }

            flag = true;
            auxk = k;
            auxn = n;
            while(auxn%auxk!=0) {
                if(flag)
                    auxk++;
                else
                    auxn--;
                flag = !flag;
                cc++;
            }


            flag = true;
            auxk = k;
            auxn = n;
            while(auxn%auxk!=0 && auxk>2 && auxn >= n/2) {
                if(flag)
                    auxk--;
                else
                    auxn++;
                flag = !flag;
                cd++;
            }
            writer.printf("%d\n", Math.min(cd, Math.min(cc, Math.min(ca, cb))));
        } else if(k > n) {
            while(auxk%auxn!=0) {
                auxk--;
                ca++;
            }

            auxk = k;
            auxn = n;
            while(auxk%auxn!=0 && auxn <= n*2) {
                auxn++;
                cb++;
            }

            flag = true;
            auxk = k;
            auxn = n;
            while(auxk%auxn!=0) {
                if(flag)
                    auxk--;
                else
                    auxn++;
                flag = !flag;
                cc++;
            }
            flag = true;
            auxk = k;
            auxn = n;
            while(auxk%auxn!=0) {
                if(flag)
                    auxk++;
                else
                    auxn--;
                flag = !flag;
                cd++;
            }
            writer.printf("%d\n", Math.min(cd, Math.min(cc, Math.min(ca, cb))));
        }
        else if(n >= k && n%k==9){
            writer.printf("0\n");
        }
    }
}
