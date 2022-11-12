import java.io.*;

public class S2E {
    static int[]count;
    static int unique;
    static int k;
    public static void add(int x){
        if(count[x] == 0)
            ++unique;
        count[x]++;
    }
    public static void remove(int x){
        count[x]--;
        if(count[x] == 0)
            --unique;
    }
    public static boolean good(){
        // System.out.println("K: " + k);
        // System.out.println("Unique: " + unique);
        return k >= unique; 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] data;
        int n;
        data = in.readLine().split(" ");
        n = Integer.valueOf(data[0]);
        k = Integer.valueOf(data[1]);
        int[] a = new int[n];
        data = in.readLine().split(" ");
        for(int i = 0 ; i < n ; ++i)
            a[i] = Integer.valueOf(data[i]);
        count = new int[100010];
        unique = 0;
        in.close();
        int l = 0, r = 0;
        long sum = 0;
        long res = 0;
        for( r = 0 ; r < n ; ++r){
            add(a[r]);
            while(l < r && !good()){
                remove(a[l]);
                ++l;
            }
            if(good())
                res+= r - l + 1;
        }

        out.write(res+"");
        out.flush();
        out.close();
    }
}
