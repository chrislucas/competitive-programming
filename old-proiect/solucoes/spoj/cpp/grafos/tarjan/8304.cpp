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

#define limit  2010

using namespace std;

typedef vector<int> vi;
typedef vector<vi>  grafo;
grafo g, gt;

bool visiteds[limit];
int matrix[limit][limit];
// algoritmo tarjan;

void add_edge(int i, int e, int d) {
    if(d == 1)
        g[i].push_back(e);
    else {
        g[i].push_back(e);
        g[e].push_back(i);
    }
    return;
}

void _add_edge(int i, int e, int d) {
    if(d == 1)
        matrix[i][e] = 1;
    else {
        matrix[i][e] = 1;
        matrix[e][i] = 1;
    }
    return;
}

void _init() {
    memset(visiteds, false, sizeof(visiteds) * sizeof(visiteds[0]));
    //memset(matrix, 0, sizeof(matrix) * sizeof(matrix[0][0]));
    return;
}
// dfs
void tarjan(grafo g, int s) {
    visiteds[s] = true;
    unsigned int sz = g[s].size();
    for(unsigned int i = 0; i < sz ; i++) {
        int v = g[s][i];
        //printf("V(%d, %d)\n", s, v);
        if( ! visiteds[v])
            tarjan(g, v);
    }
    return;
}

void _tarjan(int n) {

}

void transpose(int n) {
    gt.resize(n);
    unsigned int v = g.size();
    vector<int>::iterator it;
    for(int i=1; i<n; i++) {
        for(it = g[i].begin(); it != g[i].end(); it++) {
            int e = *it;
            //printf("V(%d %d)\n", e, i);
            gt[e].push_back(i);
        }
    }
    return;
}
bool isStrongConnect(int n) {
    for(int i=1; i<=n; i++)
        if(!visiteds[i])
            return false;
    return true;
}

//
void _test(int n) {
    vector<int>::iterator it;
    int e;
    for(int i=1; i<n; i++) {
        for(it = g[i].begin(); it != g[i].end(); it++) {
            e = *it;
            printf("V(%d %d)\n", i, e);
        }
    }
    printf("\n\n");
    for(int i=1; i<n; i++) {
        for(it = gt[i].begin(); it != gt[i].end(); it++) {
            e = *it;
            printf("V(%d %d)\n", i, e);
        }
    }
}

int solution_v1(int verts, int edges) {
    _init();
    g.resize(verts + 1);
    int i, e, w;
    for(int index=0; index<edges; index++) {
        scanf("%d %d %d", &i, &e, &w);
        //getchar();
        add_edge(i,e,w);
    }
    tarjan(g, 1);

    if( ! isStrongConnect(verts) ) {
        //printf("0\n");
        g.clear();
        return 0;
    }
    transpose(verts + 1);
    g.clear();
    _init();
    gt.resize(verts + 1);
    tarjan(gt, 1);
    //printf("%d\n", isStrongConnect(verts) == true ? 1 : 0);
    gt.clear();
    return isStrongConnect(verts) ? 1 : 0;
}

void solution_v2(int verts, int edges) {
    _init();
    int i, e, w;
    for(int index=0; index<edges; index++) {
        scanf("%d %d %d", &i, &e, &w);
        //getchar();
        add_edge(i,e,w);
    }
}
// feto
int main_8304() {
    int verts, edges;
    vector<int> rs;
    while( scanf("%d %d", &verts, &edges) && (verts || edges) ) {
        rs.push_back(solution_v1(verts, edges));
    }
    for(unsigned int i=0; i < rs.size(); i++) {
        printf("%d\n", rs[i]);
    }
    return 0;
}
