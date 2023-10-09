import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(in.readLine());
        int n, m;
        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        String s = in.readLine();
        String c = in.readLine();
        int[] cards = new int[26];
        for(int i = 0 ; i < m ; ++i){
            cards[c.charAt(i) - 'a']++;
        }

        int l = 0, r = 0;
        long res = 0l;
        for( r = 0 ; r < n ; ++r){
            cards[s.charAt(r) - 'a']--;
            while(l <= r && !isValid(cards)){
                cards[s.charAt(l) - 'a']++;
                ++l;
            }
            res+= (r - l + 1);
        }
        out.write(res+"\n");
        out.flush();
        out.close();
    }

    private static boolean isValid(int[] cards) {
        for(int card : cards){
            if(card < 0)
                return false;
        }
        return true;
    }
}
