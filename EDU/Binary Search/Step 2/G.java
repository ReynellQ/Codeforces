import java.io.*;

public class G {
    static int n, k;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.valueOf(in.readLine());
        n = Integer.valueOf(in.readLine());
        a = new int[n];
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(in.readLine());
        in.close();
        out.write(solve()+"");
        out.flush();
        out.close();
    }
    private static long solve() {
        long l = 1, r = 500000000000l, mid;
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
    private static boolean isPossible(long councils) {
        long acum = 0l;
        for(int i = 0 ; i< n ; ++i)
            acum+= Math.min(councils, a[i]);
        return acum/k >= councils;
    }
}
