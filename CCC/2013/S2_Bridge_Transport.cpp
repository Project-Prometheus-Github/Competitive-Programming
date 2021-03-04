#include <vector>
#include <array>
#include <iostream>
#include <list>

/*
 *  CCC: 15/15
 *  DMOJ: 130/130 (0.143s, 3.40 MB)
 *  Problem type: Math
 */

using namespace std;
int cars[100000]{ 0 };

int main() {
	int w, c;
	cin >> w;
	cin >> c;
	for (int i = 0; i < c; i++)
		cin >> cars[i];
	int i;
	for (i = 0; i < c; i++) {
		int cw = 0;
		for (int j = i; j >= max(0, i - 3); j--) {
			cw += cars[j];
		}
		if (cw > w)
			break;
	}
	cout << i;
}