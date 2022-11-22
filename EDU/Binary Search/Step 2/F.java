import java.io.*;
import java.util.*;

public class F {
    static char[] t, p;
    static int n, m;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        t = in.readLine().toCharArray();
        p = in.readLine().toCharArray();
        n = t.length;
        m = p.length;
        a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i){
            a[i] = Integer.valueOf(st.nextToken());
        }
        out.write(solve()+"\n");

        in.close();
        out.flush();
        out.close();
    }
    private static int solve() {
        int l = 0, r = n, mid;
        while(l < r){
            mid = l +( r - l + 1)/2;
            if(isPossible(mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
    private static boolean isPossible(int sn) {
        char[] st = new char[n];
        for(int i = 0 ; i < n ; ++i)
            st[i] = t[i];
        for(int i = 0 ; i < sn ; ++i)
            st[a[i] - 1] = '$';
        int l = 0, r = 0;
        while( l < m && r < n){
            if(p[l] == st[r]){
                l++;
            }
            r++;
        }
        return l == m;
    }
}
