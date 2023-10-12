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
    int t;
    while(t --){
        int n, m; cin >> n >> m;
        string x, s; cin >> x >> s;
        int op = 0;
        while( n < m){
            n= 2*n;
            x+=x;
            op++;
        }
        if(x.find(s) != std::string::npos){
            cout << op;
        }
        op++; x+=x;
        if(x.find(s) != std::string::npos){
            cout << op;
        }
        x+=x;
        if(x.find(s) != std::string::npos){
            cout << op;
        }else{
            cout << "-1";
        }
    }
    return 0;
}