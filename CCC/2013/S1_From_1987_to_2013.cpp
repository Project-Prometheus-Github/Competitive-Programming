#include <vector>
#include <iostream>
#include <string>

#define sz(x) (int)(x).size()

/*
 *  CCC: 15/15
 *  DMOJ: 150/150 (0.035s, 1.47 MB)
 *  Problem type: Implementation
 */

using namespace std;
int N, x, y;

int main() {
    cin >> y;
    y += 1;
    while (true) {
        string s = to_string(y);
        bool ft = false;
        for (int i = 0; i < sz(s); i++) {
            for (int j = i + 1; j < sz(s); j++) {
                if (s[j] == s[i]) ft = true;
                else continue;
            }
        }
        if (!ft) {
            printf("%i\n", y);
            break;
        }
        else {
            y++;
        }
    }
}