import java.io.*;
import java.util.*;

public class H {
    static String recipe;
    static int[] re;
    static int[] n, p;
    static long r;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        recipe = in.readLine();
        n = new int[3];
        p = new int[3];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < 3 ; ++i){
            n[i] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < 3 ; ++i){
            p[i] = Integer.valueOf(st.nextToken());
        }
        r = Long.valueOf(in.readLine());
        in.close();
        re = new int[3];
        for(int i = 0 ; i < recipe.length() ; ++i){
            if(recipe.charAt(i) == 'B'){
                re[0]++;
            }else if(recipe.charAt(i) == 'S'){
                re[1]++;
            }else{
                re[2]++;
            }
        }
        out.write(solve()+"");
        out.flush();
        out.close();
    }
    private static long solve() {
        long l = 0, r = 2000000000000l, mid;
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
    private static boolean isPossible(long hamburgers) {
        long[] cant = new long[3];
        long value = 0l;
        for(int i = 0 ; i < 3 ; ++i){
            cant[i]= hamburgers;
            cant[i]*=re[i];
            cant[i] = Math.max(0, cant[i] - n[i]);
            value+= cant[i]*p[i];
        }
        return value <= r;
    }
}
