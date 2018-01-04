bool l[5000];
int d[5000], s[5000];

void exploreCave(int N) {
	for (int door = 0; door < N; door++) {
		int left = 0;
		int right = N - 1;
		int result = tryCombination(s);
		bool req = result <= door && ~result;
		while (left != right) {
			int mid = left + right >> 1;
			for (int j = left; j <= mid; j++) {
				s[j] ^= !l[j];
			}
			result = tryCombination(s);
			for (int j = left; j <= mid; j++) {
				s[j] ^= !l[j];
			}
			if (req ^ (result > door || !~result)) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		d[left] = door;
		l[left] = true;
		s[left] = req;
	}
	answer(s, d);
}