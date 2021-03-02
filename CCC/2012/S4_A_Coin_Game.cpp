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
 *  DMOJ: 50/50 (0.247s, 14.30 MB)
 *  Problem type: Graph Theory
 */

using namespace std;
int N = 0, x, y, o;
pair<array<int, 7>, int> C({ 0 }, 0);


struct qCheckNode {
    vector<qCheckNode> children;
    int value = 0;
};

bool check(array<int, 7> arr) {
    for (int i = 1; i < N; i++) {
        if (arr[i] < arr[(i - 1)] || arr[i] == 0 || arr[i] > 7)
            return false;
    }
    return true;
}

bool doesContain(qCheckNode& p, array<int, 7> arr, int depth) {
    if (depth == N) {
        return true;
    }
    for (size_t i = 0; i < p.children.size(); ++i) {
        if (p.children[i].value == arr[depth]) {
            return doesContain(p.children[i], arr, depth + 1);
        }
    }
    return false;
}

void printNodes(qCheckNode& p) {
    cout << p.value << " ";
    for (size_t i = 0; i < p.children.size(); ++i) {
        printNodes(p.children[i]);
    }
    if (p.children.size() == 0)
        cout << "\t";
}

void add(qCheckNode& p, array<int, 7> arr, int depth) {
    if (depth < N) {
        for (size_t i = 0; i < p.children.size(); ++i) {
            if (p.children[i].value == arr[depth]) {
                add(p.children[i], arr, depth + 1);
                return;
            }
        }
        qCheckNode node;
        node.value = arr[depth]; depth++;
        add(node, arr, depth);
        p.children.push_back(node);
    }
}

int bfs(pair<array<int, 7>, int> arr) {
    pair<array<int, 7>, int> temp = arr;
    queue<pair<array<int, 7>, int>> q;
    qCheckNode node;
    q.push(arr);
    add(node, arr.first, 0);
    while (!q.empty()) {
        arr = q.front();
        q.pop();
        if (check(arr.first))
            return arr.second;
        for (int i = 0; i < N; i++) {
            if (arr.first[i] == 0)
                continue;
            for (int j = ((i - 1 > -1) ? i - 1 : i + 1); j < min(N, i + 2); j += 2) {
                if (arr.first[i] % 10 < arr.first[j] % 10 || arr.first[j] == 0) {
                    temp = arr;
                    temp.first[j] = temp.first[j] * 10 + temp.first[i] % 10;
                    temp.first[i] = temp.first[i] / 10;
                    temp.second = temp.second + 1;
                    if (!doesContain(node, temp.first, 0)) {
                        add(node, temp.first, 0);
                        q.push(temp);
                    }
                }
            }
        }
    }
    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    while (true) {
        cin >> N;
        if (N == 0)
            break;
        for (int i = 0; i < N; i++)
            cin >> C.first[i];
        o = bfs(C);
        if (o == -1)
            cout << "IMPOSSIBLE" << endl;
        else
            cout << o << endl;
    }
}