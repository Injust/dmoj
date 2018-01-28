#include <bitset>
#include <iostream>
#include <vector>

int argue[200000];
std::vector<int> group[200000];
std::bitset<200000> party;

void recurse(int at) {
	if (argue[at] > 2) {
		argue[at] = 0;
		party.flip(at);
		for (int adj : group[at]) {
			if (party[at] == party[adj]) {
				argue[at]++;
				argue[adj]++;
				if (argue[adj] > 2) {
					recurse(adj);
				}
			} else {
				argue[adj]--;
			}
		}
	}
}

int main() {
	int l, m, n, r;
	scanf("%d", &n);
	for (int i = 0; i < 5; i++) {
		scanf("%d", &m);
		for (int j = 0; j < m; j++) {
			scanf("%d %d", &l, &r);
			argue[l - 1]++;
			argue[r - 1]++;
			group[l - 1].push_back(r - 1);
			group[r - 1].push_back(l - 1);
		}
	}
	for (int i = 0; i < n; i++) {
		recurse(i);
	}
	for (int i = 0; i < n; i++) {
		printf(party[i] ? "A" : "B");
	}
	return 0;
}