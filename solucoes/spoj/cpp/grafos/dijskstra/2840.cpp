//http://br.spoj.com/problems/ENGARRAF/
#include <algorithm>
#include <bitset>
#include <climits>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <ctime>
#include <cstring>
#include <deque>
#include <iostream>
#include <iterator>
#include <functional>
#include <list>
#include <limits>
#include <string>
#include <sstream>
#include <stack>
#include <map>
#include <numeric>
#include <queue>
#include <set>
#include <utility>
#include <vector>

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>

using namespace std;

#define loop(i, val, e) for(typeof(val) i = (val); i < (e); i++)

typedef pair<int, int> p;
typedef vector<p> vp;
typedef vector<vp> G;

G g;

int distt[10001];
bool visits[10001];

// dijkstra com priority queue
void dpq(int s, int e) {
    priority_queue<p, vp, greater<p> > pl_pairs;
    distt[s] = 0;
    // adiciona o par(vertice de inicio, e peso para ele mesmo);
    pl_pairs.push(make_pair(s, 0));
    while(!pl_pairs.empty()) {
        p _pair = pl_pairs.top();
        pl_pairs.pop();
        // origin da busca
        int o = _pair.first;
        // quantidade de vertices ligados a vertice o 'origem'
        unsigned int v= (int) g[o].size();
        for(int i=0; i<v; i++) {
            // vertice adjacente a 'o' e seu peso w 'weight'
            int d = g[o][i].first, w = g[o][i].second;
            if(distt[d] > distt[o] + w) {
                distt[d] = distt[o] + w;
                pl_pairs.push(make_pair(d, distt[w]));
            }
        }
    }
    return;
}
// s -> vertice de inicio, q, quantidade de vertices
void dfs(int s) {
    visits[s] = true;
    unsigned int _sz = g[s].size();
    for(int i=0; i<_sz; i++) {
        int v = g[s][i].first, weight = g[s][i].second;
        //cout<<"V(" <<i <<"," <<v <<") peso " <<weight <<endl;
        if(!visits[v])
            dfs(v);
    }
}

// um dijkstra;
void d() {
    return;
}

void addEdge(int s, int e, int w) {
    g[s].push_back(make_pair(e, w));
    return;
}

void ini(int limite) {
    int i;
    g.resize(1000);
    loop(i, 0, limite + 1) {
        distt[i] = INT_MAX;
        visits[i] = false;
    }
    return;
}

int main() {
    int cidades, ruas;
    while(scanf("%d %d", &cidades, &ruas) && (cidades || ruas)) {
        getchar();
        ini(cidades);
        int s, e, w;
        while(ruas--) {
           scanf("%d %d %d", &s, &e, &w);
           addEdge(s, e, w);
        }
        // variaveis que indicar o comeco e o fim do percurso
        int a, b;
        scanf("%d %d", &a, &b);
        dfs(a);
        if(visits[b] == false)
            printf("%d\n", -1);
        else {
            dpq(a, b);
            printf("%d\n", distt[b]);
        }
        /*
        G::iterator it;
        it = g.begin();
        while( it != g.end()) {
            g.erase(it++);
        }
        */
        g.clear();
    }
    return 0;
}
