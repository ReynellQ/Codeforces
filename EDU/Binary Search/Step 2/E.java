import java.io.*;
import java.util.*;

public class E {
    static double epsilon = 1e-6;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        double c = Double.parseDouble(in.readLine());
        out.write(solve(c)+"");
        in.close();
        out.flush();
        out.close();
    }
    private static double solve(double c) {
        double l = 0.0, r = c, mid;
        while(r - l > epsilon){
            mid = (l + r)/2.0;
            if(mid*mid + sqrt(mid) <= c){
                l = mid;
            }else{
                r = mid;
            }
        }
        return l;
    }
    private static double sqrt(double x){
        double l = 0.0, r = x + 1.0, mid;
        while(r - l > epsilon){
            mid = (l + r)/2.0;
            if(mid*mid <= x){
                l = mid;
            }else{
                r = mid;
            }
        }
        return l;
    }
}
