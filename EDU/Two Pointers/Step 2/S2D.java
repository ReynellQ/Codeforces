import java.io.*;

public class S2D {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data;
        int n;
        long s;
        data = in.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        s = Long.valueOf(data[1]);
        long[] a = new long[n];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            a[i] = Long.valueOf(data[i]);
        in.close();
        int l = 0, r = 0;
        long sum = 0;
        long res = 0;
        for( r = 0 ; r < n ; ++r){
            sum+= a[r];
            while(l < r && sum - a[l] >= s){
                sum-=a[l];
                l++;
            }
            if(sum >= s)
                res+= (r + 1) - (r -  l);
        }

        out.write(res+"");
        out.flush();
        out.close();
    }

}
