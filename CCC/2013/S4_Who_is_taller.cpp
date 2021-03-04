#include <vector>
#include <array>
#include <iostream>
#include <list>

/*
 *  CCC: 15/15
 *  DMOJ: 200/300 (---s, 33.69 MB)
 *  Problem type: Graph Theory
 */

using namespace std;
array<vector<int>, 1000000> students;

bool isTaller(int a, int b) {
	for (long unsigned int i = 0; i < students[a].size(); i++) {
		if (students[a][i] == b)
			return "yes";
		if (!students[students[a][i]].empty() && isTaller(students[a][i], b) == "yes")
			return "yes";
		students[students[a][i]].clear();
	}
	for (long unsigned int i = 0; i < students[b].size(); i++) {
		if (students[b][i] == a)
			return "no";
		if (isTaller(a, students[b][i]) == "no")
			return "no";
	}
	return "unknown";
}

int main() {
	int N, M, a, b;
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		cin >> a >> b;
		students[a].push_back(b);
	}
	cin >> a >> b;
	cout << isTaller(a, b);
}