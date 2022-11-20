import java.io.*;
import java.util.*;

public class C {
    static double epsilon = 1e-7;
    static int n, k;
    static int[] a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        a = new int[n];
        b = new int[n];
        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(in.readLine());
            a[i] = Integer.valueOf(st.nextToken());
            b[i] = Integer.valueOf(st.nextToken());
        }
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }

    
    private static double solve() {
        double l = 0.0, r = 1e6, mid;
        while( r - l > epsilon){
            mid = (l + r)/2.0;
            if(isPossible(mid)){
                l = mid;
            }else{
                r = mid;
            }
        }
        return l;
    }


    private static boolean isPossible(double mean) {
        double[] m = new double[n];
        for(int i = 0 ; i < n ; ++i)
            m[i] = a[i] - b[i]*mean;
        Arrays.sort(m);
        double acum = 0.0;
        for(int i = 0 ; i < k ; ++i){
            acum+= m[n - i - 1];
        }
        return acum>= 0;
    }
}
