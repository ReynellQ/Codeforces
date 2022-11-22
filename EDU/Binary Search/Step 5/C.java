import java.io.*;
import java.util.*;

public class C {
    static int n;
    static long k;

    static int[] a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Long.valueOf(st.nextToken());
        a = new int[n];
        b = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(st.nextToken());
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i)
            b[i] = Integer.valueOf(st.nextToken());
        Arrays.sort(a);
        Arrays.sort(b);
        out.write(solve()+"");
        in.close();
        out.flush();
        out.close();
    }
    private static long solve() {
        long l = 0, r = 2000000000, mid;
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
        int l = 0, r = n - 1;
        long acum = 0l;
        for(l = 0 ; l < n ; ++l){
            while(r > -1 && a[l] + b[r] > value){
                r--;
            }
            acum+= r + 1;
        }
        return acum < k;
    }
}
