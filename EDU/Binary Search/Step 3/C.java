import java.io.*;
import java.util.*;
 
public class C {
    static int n, k;
    static int[] stalls;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        stalls = new int[n];
        st = new StringTokenizer(in.readLine());
        for(int i = 0 ; i < n ; ++i){
            stalls[i] = Integer.valueOf(st.nextToken());
        }
        
        in.close();
        long res = bs();
        out.write(res+"");
        out.flush();
        out.close();
    }
    public static long bs(){
        long l = -1, r = Integer.MAX_VALUE, mid;
        while(l < r){
            mid = l + (r - l + 1) / 2;
            if(isPossible(mid)){
                l = mid;
            }else{
                r = mid - 1;    
            }
        }
        return l;
    }
    private static boolean isPossible(long minimumLength) {
        int stall = stalls[0];
        int cows = 1;
        for(int i = 1 ; i < n ; ++i){
            if( stalls[i]-stall >= minimumLength ){
                stall = stalls[i];
                cows++;
            }
        }
        return cows >= k;
    }
}