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
        int n; cin >> n;
        vector<vector<int>> m(n, vector<int>(n));
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < n ; ++j){
                cin >> m[i][j];
            }
        }
        vector<vector<int>> r(n, vector<int>(n));
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < n ; ++j){
                r[i][j] = r[j][ n - 1 - i];
                cout << r[i][j] << " ";
            }
            cout << "\n";
        }

    }
    return 0;
}