import java.io.*;
import java.util.*;

public class A {
    static double epsilon = 1e-7;
    static int n, d;
    static int[] a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        d = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(in.readLine());
        a = new int[n];
        for(int i = 0 ; i < n ; ++i){
            a[i] = Integer.valueOf(st.nextToken());
        }
        double mean = solve();
        //System.out.println(mean);
        int[] res = reconstruct(mean);
        out.write((res[0]) + " "+ (res[1])+"");
        in.close();
        out.flush();
        out.close();
    }

    
    private static double solve() {
        double l = 0.0, r = 1e2 + 1, mid;
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
        double[]b = new double[n];
        for(int i = 0 ; i < n ; ++i){
            b[i] = a[i] - mean;
        }
        double[] p = new double[n + 1];
        p[0] = 0;
        for(int i = 1 ; i <= n ; ++i){
            p[i] = p[i - 1] + b[i - 1];
        }
        int l = 0, r =d;
        double ml = Double.MAX_VALUE;
        for( ; r <= n ; ++r, ++l){
            if(ml > p[l]){
                ml = p[l];
            }
            if(p[r] >= ml){
                return true;
            }
        }
        return false;
    }

    private static int[] reconstruct(double mean) {
        double[]b = new double[n];
        for(int i = 0 ; i < n ; ++i){
            b[i] = a[i] - mean;
        }
        double[] p = new double[n + 1];
        p[0] = 0;
        for(int i = 1 ; i <= n ; ++i){
            p[i] = p[i - 1] + b[i - 1];
        }
        int l = 0, r =d;
        double ml = Double.MAX_VALUE;
        int mL = 0;
        for( ; r <= n ; ++r, ++l){
            if(ml > p[l]){
                ml = p[l];
                mL = l;
            }
            if(p[r] >= ml){
                return new int[]{mL + 1, r};
            }
        }
        return new int[]{-1, -1};
    }
}
