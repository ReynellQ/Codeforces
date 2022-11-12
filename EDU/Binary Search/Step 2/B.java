import   java.io.*;
import java.util.*;

public class B {
    static double epsilon = 1e-6;
    static int n, k;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        a = new int[n];
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(in.readLine());
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }
    private static double solve() {
        double l = 0.0, r = 1e10, mid;

        while(r -l > epsilon){
            mid = (l + r)/2.0;
            if(isPossible(mid)){
                l = mid;
            }else{
                r = mid;
            }
        }
        return l;
    }
    private static boolean isPossible(double len) {
        int ropes = 0;
        for(int i = 0 ; i < n ; ++i){
            ropes += (1.0*a[i])/len;
        }
        return ropes >= k;
    }
    
}
