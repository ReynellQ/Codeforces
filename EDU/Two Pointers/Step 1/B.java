import java.io.*;
import java.util.*;
public class B {
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
        int[] res = new int[m];
        int i = 0, j = 0;
        for( j = 0 ; j < m ; ++j){
            while(i < n && a[i] < b[j])
                ++i;
            res[j] = i;
            out.write(res[j]+ " ");
        }
 
        in.close();
        out.flush();
        out.close();
    }
}
