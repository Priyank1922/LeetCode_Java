class Solution {
public double myPow(double x, int n) {
long N = n;
if (N < 0) {
        N = -N;
    }

    double result = 1.0;
    double base = x;

    while (N > 0) {
        if ((N & 1) != 0) {
            result *= base;
        }

        base *= base;
        N >>= 1;
    }

    if (n < 0) {
        result = 1.0 / result;
    }

    return result;
}
}
