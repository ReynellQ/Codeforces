import java.io.*;
import java.util.*;
 
public class D {
    static int m, n;
    static int[] t, y, z;
    static int[] res;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        t = new int[n];
        y = new int[n];
        z = new int[n];
        res = new int[n];
        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(in.readLine());
            t[i] = Integer.valueOf(st.nextToken());
            z[i] = Integer.valueOf(st.nextToken());
            y[i] = Integer.valueOf(st.nextToken());
        }
        long time = solve();
        out.write(time+"\n");
        notPossible(time);
        int ballons = 0;
        for(int i = 0 ; i < n ; ++i){
            ballons+=res[i];
            int p = res[i];
            if(ballons > m){
                p = Math.max(0, res[i] - (ballons - m));
            }
            out.write(p+" ");
        }
        in.close();
        out.flush();
        out.close();
    }
    private static long solve() {
        long l = -1, r = Integer.MAX_VALUE - 10, mid;
        while(l < r){
            mid = l +( r - l + 1)/2;
            if(notPossible(mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l + 1;
    }
    private static boolean notPossible(long time) {
        long balloons = 0l;
        for(int i = 0 ; i < n ; ++i){
            res[i] = ballons(t[i], y[i], z[i], time);
            balloons+= res[i];
        }
        return balloons < m;
    }
    private static int ballons(int t, int y, int z, long time) {
        long l = 0, r = 1000000, mid;
        while(l < r){
            mid = l +( r - l + 1)/2;
            long value = t*mid + y*( (int)Math.ceil((1.0*mid)/z) - 1);
            if(value <= time){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return (int)l;
    }
}
