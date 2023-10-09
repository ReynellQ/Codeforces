import java.io.*;
import java.util.*;
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]data;
        int n, m;
        data = in.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        m = Integer.valueOf(data[1]);
        int[] a = new int[n];
        int[] b = new int[m];
        int[] c = new int[n + m];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(data[i]);
        data = in.readLine().split(" ");
        for(int i = 0 ; i < m ; ++i)
            b[i] = Integer.valueOf(data[i]);
        long res = 0l;
        int i = 0, j = 0;
        while(i < n && j < m){
            int nI = i, nJ = j;
            if(a[i] < b[j]){
                i++;
            }else if(a[i] > b[j]){
                j++;
            }else{
                for( ; nI < n ; ++nI)
                    if(a[i] != a[nI])
                        break;
                for( ; nJ < m ; ++nJ)
                    if(b[j] != b[nJ])
                        break;
                // System.out.println("Arreglo A: " + i + ", " + nI);
                // System.out.println("Arreglo B: " + j + ", " + nJ);
                long product = (nI - i);
                product*= (nJ -  j);
                res+= product;
                i = nI;
                j = nJ;
            }
            
        }
        out.write(res+"");
        in.close();
        out.flush();
        out.close();
    }
}
