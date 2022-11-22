import java.io.*;
import java.util.*;

public class Round341B {
    static boolean[][] grid = new boolean[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.valueOf(in.readLine());
        int[] diag1 = new int[2001];
        int[] diag2 = new int[2001];
        for(int i = 0 ; i < n ; ++i){
            st = new StringTokenizer(in.readLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());
            grid[x][y] = true;
            diag1[x + y]++;
            diag2[x - y + 1000]++;
        }
        long res = 0l;
        for(int i = 0 ; i <=2000; ++i) res+= diag1[i]*(diag1[i] - 1)/2;
        for(int i = 0 ; i <=2000; ++i) res+= diag2[i]*(diag2[i] - 1)/2;
        out.write(res+"");
        in.close();
        out.flush();
        out.close();
    }
}
