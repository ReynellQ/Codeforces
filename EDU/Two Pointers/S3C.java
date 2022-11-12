import java.io.*;

public class S3C {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data;
        int n;
        long D;
        data = in.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        D = Long.valueOf(data[1]);
        long[] a = new long[n];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            a[i] = Long.valueOf(data[i]);
        in.close();
        int l = 0, r = 0;
        long res = 0l;
        for( r = 0 ; r < n ; ++r){
            while(l < r && a[r] - a[l + 1] > D){
                ++l;
            }
            // System.out.println(l +  " " + r);
            if(a[r] - a[l] > D)
                res+=(l + 1);
        }

        out.write(res+"");
        out.flush();
        out.close();
    }
}
