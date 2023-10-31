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
 
int main()
{
    int T; cin >> T;
    while(T--){
        int n; cin >> n;
        vector<ll> a(n);
        vector<int> desp(n);
        for(int i = 0 ; i < n ; ++i) cin >> a[i];
        desp[0] = 0;
        for(int i = 1 ; i < n ; ++i){
            int A = a[i - 1];
            int B = a[i];
            desp[i] = desp[i - 1];
            if(A < B){
                while(A*2 <= B && desp[i] > 0){
                    desp[i]--;
                    A= A*2;
                }
            }else{
                while(B < A){
                    desp[i]++;
                    B = B * 2;
                }
            }
        }
        
        ll res = 0ll;
        for(int i = 0 ; i < n ; ++i)
        res+= desp[i];
        cout << res << "\n";
 
    }
    return 0;
}