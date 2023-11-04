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

void initIO(string name = ""){
    ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
    if (name.size()) {
		freopen((name + ".in").c_str(), "r", stdin);
		freopen((name + ".out").c_str(), "w", stdout);
	}
}
int main(){
    initIO("");
    int t; cin >> t;
    while(t--){
        int n; cin >> n;
        vector<int> a(2*n);
        for(int i = 0 ; i < 2*n ; ++i){
            cin >> a[i];
        }
        sort(a.begin(), a.end());
        vector<pair<int,int>>p(n);
        for(int i = 0 ; i < n ; ++i){
            p[i] = {a[i], a[2*n - i - 1]};
        }
        ll sum = 0;
        for(int i =1 ; i < n ; ++i){
            sum += abs(p[i - 1].f - p[i].f) + abs(p[i - 1].s - p[i].s);
        }
        cout << sum <<"\n";
        for(int i = 0 ; i < n ; ++i){
            cout << a[i] << " " << a[2*n - i- 1] << "\n";
        }
    }

    
    return 0;
}