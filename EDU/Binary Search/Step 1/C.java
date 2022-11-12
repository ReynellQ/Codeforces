import java.io.*;
import java.util.*;
 
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n, k;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i){
            a[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.sort(a);
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < k ; ++i){
            int x = Integer.valueOf(st.nextToken());
            int res = bs(a,x);
            ++res;
            out.write( res+"\n");
        }
        in.close();
        out.flush();
        out.close();
    }
 
    private static int bs(int[] a, int x) {
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
}