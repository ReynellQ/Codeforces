import   java.io.*;
import java.util.*;

public class B {
    static long n;
    static long k;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Long.valueOf(st.nextToken());
        k = Long.valueOf(st.nextToken());
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }
    private static long solve() {
        long l = 0, r = n*n + 1, mid;
        while(l < r){
            mid = (l + r + 1)/2;
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
        for(int i = 1 ; i <= n ; ++i){
            acum+= Math.min(n, value/i);
        }
        return acum < k;
    }
   
    
}
