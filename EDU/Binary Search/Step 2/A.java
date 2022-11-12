import   java.io.*;
import java.util.*;

public class A {
    static int w, h, n;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        w = Integer.valueOf(st.nextToken());
        h = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }
    private static long solve() {
        long l = 0, r = 1, mid;
        while(notPossible(r))
            r*=2;
        while(l + 1 < r){
            mid = (l + r)/2;
            if(notPossible(mid)){
                l = mid;
            }else{
                r = mid;
            }
        }
        return l + 1;
    }
    private static boolean notPossible(long x) {
        long b = x/w;
        long a = x/h;
        if(b == 0 || a == 0)
            return true;
        return b*a < n;
    }
}
