#define scan(x)do{while((x=getchar())<'0');for(x-='0';'0'<=(_=getchar());x=(x<<3)+(x<<1)+_-'0');}while(0)
#include <algorithm>
#include <iostream>

char _;
const int MAXN = 1000000;
typedef std::pair<long long, int> pli;

struct BIT {
    int maxind = MAXN;
    int data[MAXN + 1] = {0};

    void add(int ind) {
        for (; ind <= maxind; ind += -ind & ind) {
            data[ind]++;
        }
    }

    int query(int ind) {
        int ret = 0;
        for (; ind > 0; ind -= -ind & ind) {
            ret += data[ind];
        }
        return ret;
    }
};

int main() {
    int n;
    scan(n);
    pli psa[MAXN + 1];
    for (int i = 1; i <= n; i++) {
        scan(psa[i].first);
        psa[i].second = i;
    }
    int p;
    scan(p);
    for (int i = 1; i <= n; i++) {
        psa[i].first += psa[i - 1].first - p;
    }
    sort(psa, psa + n + 1);
    BIT bit;
    long long out = 0;
    for (int i = 0; i <= n; i++) {
        out += bit.query(psa[i].second + 1);
        bit.add(psa[i].second + 1);
    }
    printf("%lld\n", out);
    return 0;
}