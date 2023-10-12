#include <bits/stdc++.h>
#define INF INT_MAX
#define MINF INT_MIN
#define ll long long
#define PB push_back 
#define PF push_front
#define P_F pop_front
#define P_B pop_back
#define F front
#define B back
#define f first
#define s second
#define MP make_pair
#define FOR(i, a, b) for(ll i = a; i < b; i++)
#define FORI(i, a, b) for(ll i = a; i >= b; i--)

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int t; cin >> t;
    while(t--){
        int a, b, c; cin >> a >> b >> c;
        set<int> s;
        s.insert(a);
        s.insert(b);
        s.insert(c);
        int m = min(a, min(b, c));
        for(int i = 0 ; i < 3 ; ++i){
            int M = *s.rbegin();
            if( m != M){
                s.erase(M);
                s.insert(M - m);
            }
        }
        cout << (s.size() == 1 ? "Yes" : "No") << "\n";
    }
    return 0;
}