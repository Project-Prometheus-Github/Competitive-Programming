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
 *  DMOJ: 50/50 (0.627s, 1.49 MB)
 *  Problem type: Implementation
 */

using namespace std;

#define pb push_back
#define loop(s,f) for(int i = s; i < f; i++)
#define ii pair<int,int>
#define iii pair<int, pair<int,int>>
#define ll long long

using namespace std;

int N;
ii high = make_pair(0, 0), sHigh = make_pair(0, 0);
array<ii, 1000> reads;

bool sortReads(ii r1, ii r2) {
    if (r1.first == r2.first)
        return r1.second > r2.second;
    return r1.first > r2.first;
}

int main() {
    cin >> N;
    int a, max = 0;
    loop(0, 1000) {
        reads[i].first = 0;
        reads[i].second = i;
    }
    loop(0, N) {
        cin >> a;
        if (a > max)
            max = a;
        reads[a-1].first++;
    }
    sort(reads.begin(), reads.end(), sortReads);
    a = 1;
    int highGap = reads[1].first;
    for (; a < max; a++) {
        if (a + 1 == max || reads[a + 1].first != highGap)
            break;
    }
    int s = abs(reads[0].second - reads[1].second);
    if (abs(reads[0].second - reads[a].second) > s)
        s = abs(reads[0].second - reads[a].second);
    cout << s << endl;
}