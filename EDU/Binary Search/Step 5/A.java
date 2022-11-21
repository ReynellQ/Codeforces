import   java.io.*;
import java.util.*;

public class A {
    static int n;
    static long k;
    static long[] l, r;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Long.valueOf(st.nextToken()) + 1;
        l = new long[n];
        r = new long[n];
        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(in.readLine());
            l[i] = Long.valueOf(st.nextToken());
            r[i] = Long.valueOf(st.nextToken());
        }
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }
    private static long solve() {
        long l = Integer.MIN_VALUE - 1l, r = Integer.MAX_VALUE + 1l, mid;
        while(l < r){
            mid = l + (r - l + 1)/2;
            if(notPossible(mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l + 1;
    }
    private static boolean notPossible(long value) {
        long acum = 0;
        for(int i = 0 ; i < n ; ++i){
            acum += Math.min( r[i] - l[i] + 1, Math.max(0, value - l[i] + 1));
        }
        return acum < k;
    }
}
