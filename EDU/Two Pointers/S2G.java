import java.io.*;

public class S2G {
    static class ST{
        public long value; // El valor cambia con el problema
        ST l;
        ST r;
        int begin, end, mid;
        ST(long[]arr, int i, int j){
            begin = i; end = j; mid = (i+j)/2;
            if(begin == end)
                value = arr[begin];
            else{
                l = new ST(arr, begin, mid);r = new ST(arr,mid + 1, end);
                this.value = merge(l.value, r.value);
            }
        }
        private long merge(long left, long right){
            return gcd(left, right);
        }
        public long query(int i, int j){
            if(i == begin && j == end){
                return value;
            }else{
                if(i <= mid && j <= mid) return l.query(i, j);
                if(i > mid) return r.query(i, j);
                return merge(l.query(i, mid), r.query(mid+1, j));
            }
        }
        public long gcd(long a, long b){
            return b == 0 ? a : gcd(b, a %b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data;
        int n;
        n = Integer.valueOf(in.readLine());
        long[] a = new long[n];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            a[i] = Long.valueOf(data[i]);
        ST tree = new ST(a, 0, n - 1);
        in.close();
        int l = 0, r = 0;
        int minSeg = Integer.MAX_VALUE;
        for( r = 0 ; r < n ; ++r){
            while(l < r && tree.query(l + 1, r) == 1){
                ++l;
            }
            if(tree.query(l, r) == 1){
                minSeg = Math.min(minSeg, r - l + 1);
            }
        }
        if(minSeg == Integer.MAX_VALUE)
            minSeg = -1;
        out.write(minSeg+"");
        out.flush();
        out.close();
    }
}
