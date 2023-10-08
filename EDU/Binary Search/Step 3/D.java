import java.io.*;
import java.util.*;

public class D {
    static final int INF = 1000000001;
    static int n, m, d;
    static Edge[] edges;
    static int dp[];
    static int[] comeFrom;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        d = Integer.valueOf(st.nextToken());
        edges = new Edge[m];
        dp = new int[n + 1];
        comeFrom = new int[n + 1];
        for(int i = 0 ; i < m ; ++i){
            st = new StringTokenizer(in.readLine());
            int a, b, w;
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());
            w = Integer.valueOf(st.nextToken());
            edges[i] = new Edge(a, b, w);
        }
        in.close();
        Arrays.sort(edges, (a, b) -> a.a - b.a);
        int res = solve();
        if(res == INF){
            out.write("-1");
        }else{
            notPossible(res);
            // out.write(res+"\n");
            out.write(dp[n]+"\n");
            Stack<Integer> s = new Stack<>();
            int val = n;
            for(int i = 0 ; i <= dp[n] ; ++i){
                s.add(val);
                val = comeFrom[val];
            }
            while(!s.isEmpty())
                out.write(s.pop()+ " ");
        }
        out.flush();
        out.close();
    }
    private static int solve() {
        int l = -1, r = INF - 1, mid;
        while(l < r){
            mid = l + (r - l + 1) / 2;
            if(notPossible(mid)){
                // System.out.println("No es posible hacerlo con " + mid);
                l = mid;
            }else{
                // System.out.println("Es posible hacerlo con " + mid);
                r = mid - 1;    
            }
        }
        return l + 1;
    }
    private static boolean notPossible(int maxValue) {
        for(int i = 1 ; i <= n ; ++i)
            dp[i] = d + 1;
        comeFrom[1] = -1;
        dp[1] = 0;
        for(Edge e : edges){
            if(e.w <= maxValue){
                if(dp[e.b] > dp[e.a] + 1){
                    dp[e.b] = dp[e.a] + 1;
                    comeFrom[e.b] = e.a;
                }
                
            }
        } 
        return dp[n] > d;
    }
    static class Edge{
        int a, b, w;
        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
        
    }
}
