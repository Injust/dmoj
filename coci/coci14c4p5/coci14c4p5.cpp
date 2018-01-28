#define scan(x)do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
#include <bitset>
#include <iostream>
#include <vector>

char _;
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
	scan(n);
	for (int i = 0; i < 5; i++) {
		scan(m);
		for (int j = 0; j < m; j++) {
			scan(l);
			scan(r);
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