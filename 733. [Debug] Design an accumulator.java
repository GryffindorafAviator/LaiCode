// Debug
// There are bugs in the given code, please fix them.

// Design an accumulator, which can take a new integer using function “add”, and can return the sum of all taken integers up to now using function “sum”.

class Accumulator {
  int s = 0;
  public void add(int x) {
    s += x;
  }
  public int sum() {
    return s;
  }
}
