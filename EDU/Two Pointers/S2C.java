import java.io.*;

public class S2C {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data;
        int n;
        long s;
        data = in.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        s = Long.valueOf(data[1]);
        int[] a = new int[n];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(data[i]);
        in.close();
        int l = 0, r = 0;
        long sum = 0;
        long res = 0;
        for( r = 0 ; r < n ; ++r){
            sum+= a[r];
            while(l < r && sum > s){
                sum-=a[l];
                l++;
            }
            if(sum <= s )
                res += r - l + 1;
        }
        out.write(res+"");
        out.flush();
        out.close();
    }
}
