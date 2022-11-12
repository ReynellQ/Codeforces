import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n, k;
        n = Integer.valueOf(in.readLine());
        int[] a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i){
            a[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(a);
        k = Integer.valueOf(in.readLine());
        for(int i = 0 ; i < k ; ++i){
            st = new StringTokenizer(in.readLine());
            int l, r, L, R;
            l = Integer.valueOf(st.nextToken());
            r = Integer.valueOf(st.nextToken());
            L = bs1(a, l);
            R = bs2(a, r);
            
            int res = R - L + 1;
            if(a[R] > r)
                --res;
            out.write(res+" ");
        }
        in.close();
        out.flush();
        out.close();
    }
    private static int bs1(int[] a, int x) {
        int l = -1, r = a.length - 1, mid ;
        while(l < r){
            mid = (l + r + 1)/2;
            if(a[mid] < x){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l + 1;
    }
    private static int bs2(int[] a, int x) {
        int l = 0, r = a.length - 1, mid ;
        while(l < r){
            mid = (l + r + 1)/2;
            if(a[mid] <= x){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
