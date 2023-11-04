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
int prefix_sum(vector<int>&sum, int i, int j){
    return sum[j] - sum[i];
  }
int main(){
    initIO("");
    int n; cin >> n;
    vector<string> s(n);
    vector<vector<int>>P(n);
    ll ans = 0;
    vector<map<int, ll> > m(6);
    for(int i = 0 ; i < n ; ++i){
        string x; cin >> x;
        s[i] = x;
        int total = 0;
        vector<int> p(x.size() + 1);
        for(int j = 0 ; j < x.size() ; ++j){
            total+= (x[j] - '0');
            p[j + 1] = p[j] + (x[j] - '0');
        }
        P[i] = p;
        int sum = total;
        auto it = m[x.size()].find(sum);
        if(it != m[x.size()].end()) it->s++;
        else m[x.size()].insert({sum, 1});
    }

  for(int i = 0 ; i < n ; ++i){
    int cnt = 1;
    for(int j = s[i].size(); j >= (s[i].size() & 1 ? 1 : 2); j -= 2){
      if(j == s[i].size()){
        int sum = prefix_sum(P[i], 0, s[i].size());
        auto it = m[j].find(sum);
        if(it != m[j].end()) ans += it->s;
        continue;
      }

      int sumL = prefix_sum(P[i], 0, cnt); 
      int sumR = prefix_sum(P[i], cnt, s[i].size());
      auto it = m[j].find(sumR - sumL);
      if(it != m[j].end()) ans += it->s;

      sumL = prefix_sum(P[i], 0, s[i].size() - cnt);
      sumR = prefix_sum(P[i], s[i].size() - cnt, s[i].size());
      it = m[j].find(sumL - sumR);
      if(it != m[j].end()) ans += it->s;
      cnt++;
    }
  }

  cout << ans << "\n";
    
    return 0;
}