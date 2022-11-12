import   java.io.*;
import java.util.*;

public class C {
    static int n, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        int X, Y;
        X = Integer.valueOf(st.nextToken());
        Y = Integer.valueOf(st.nextToken());
        x = Math.min(X, Y);
        y = Math.max(X, Y);
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }
    private static long solve() {
        long l = 0, r = Long.MAX_VALUE - Integer.MAX_VALUE, mid;
        while(l < r){
            // System.out.println(l +" " +r);
            mid = l +  (r - l + 1)/2;
            if(notPossible(mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l + 1;
    }
    private static boolean notPossible(long time) {
        long copies = time >= x ? 1l : 0l;
        time= Math.max(time - x, 0);
        copies+= (time/x) + (time/y);
        return copies < n;
    }
    
}
