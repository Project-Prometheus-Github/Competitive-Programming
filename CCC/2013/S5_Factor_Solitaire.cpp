#include <vector>
#include <array>
#include <iostream>
#include <list>

/*
 *  CCC: 15/15
 *  DMOJ: 150/150 (0.149s, 26.00 MB)
 *  Problem type: Greedy algorithms, Harder math
 */

using namespace std;
array<vector<int>, 1000000> students;

int N, ans;
int main() {
    cin >> N;
    while (N > 1) {
        for (int i = 2; i <= N; i++)
            if (N % i == 0) {
                int n = N / i;
                N -= n;
                ans += N / n;
                break;
            }
    }
    cout << ans;
    return 0;
}