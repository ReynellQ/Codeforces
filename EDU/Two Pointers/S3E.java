import java.io.*;

public class S3E {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data;
        int n;
        long s;
        data = in.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        s = Long.valueOf(data[1]);
        long[] w = new long[n], c = new long[n];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            w[i] = Long.valueOf(data[i]);
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            c[i] = Long.valueOf(data[i]);
        in.close();
        int l = 0, r = 0;
        long res = 0l;
        long weight = 0l, cost = 0l;
        for( r = 0 ; r < n ; ++r){
            weight+=w[r];
            cost+= c[r];
            while(l <= r && weight > s){
                weight-=w[l];
                cost-=c[l];
                ++l;
            }
            if(weight <= s)
                res = Math.max(res, cost);
        }

        out.write(res+"");
        out.flush();
        out.close();
    }
}
