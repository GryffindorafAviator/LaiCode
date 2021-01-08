// Easy
// Design an accumulator, which can take a new integer using function “add”, and can return the sum of all taken integers up to now using function “sum”.

class Accumulator {
  int ans = 0;
	public void add(int x) {
    ans += x;
	}
	public int sum() {
    return ans;
	}
}
