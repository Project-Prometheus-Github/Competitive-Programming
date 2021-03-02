#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <queue>
#include <set>
#include <list>
#include <unordered_map>
#include <map>
#include <array>
#include <cstring>
#include <deque>

/*
 *  CCC: N/A
 *  DMOJ: 50/50 (0.012s, 1.44 MB)
 *  Problem Type: Simple math
 */

using namespace std;

#define pb push_back
#define loop(s,f) for(int i = s; i < f; i++)
#define ii pair<int,int>
#define iii pair<int, pair<int,int>>
#define ll long long

int N, x, y;

int solve(int index) {
    int out{ 0 };
    int j{ index };
    for (int i = 1; i <= index; i++) {
        out += i * j; j--;
    }
    return out;
}

int main() {
    int N;
    cin >> N;
    if (N < 4)
        cout << 0;
    else
        cout << solve(N - 3);
}