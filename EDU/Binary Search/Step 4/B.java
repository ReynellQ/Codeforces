import java.io.*;
import java.util.*;

public class B{
    static double epsilon = 1e-7;
    static int n, m;
    static int[] prev;
    static double[] dp;
    static Edge[] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        edges = new Edge[m];
        for(int i = 0 ; i < m ; ++i){
            st = new StringTokenizer(in.readLine());
            int a, b, c;
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            c = Integer.valueOf(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }
        double mean = solve();
        Stack<Integer> res = new Stack<>();
        int p = n;
        while(p != 0){
            res.add(p);
            p = prev[p];
        }
        out.write((res.size() - 1)+"\n");
        while(!res.isEmpty()){
            out.write(res.pop()+" ");
        }
        in.close();
        out.flush();
        out.close();
    }

    
    private static double solve() {
        double l = 0.0, r = 1000.0, mid;
        while( r - l > epsilon){
            mid = (l + r)/2.0;
            if(notPossible(mid)){
                l = mid;
            }else{
                r = mid;
            }
        }
        return r;
    }


    private static boolean notPossible(double mean) {
        dp = new double[n + 1];
        prev = new int[n + 1];
        Arrays.fill(dp, 100000000);
        dp[1] = 0;
        prev[1] = 0;
        for(Edge i : edges){
            if(dp[i.b] > dp[i.a] + i.w - mean){
                dp[i.b] = dp[i.a] + i.w - mean;
                prev[i.b] = i.a;
            }
        }
        return dp[n]> 0;
    }


    static class Edge{
        int a;
        int b;
        int w;
        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        
    }
}