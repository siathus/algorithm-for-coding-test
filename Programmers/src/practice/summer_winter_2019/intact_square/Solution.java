package practice.summer_winter_2019.intact_square;

import java.math.BigInteger;

// Summer/Winter Coding(2019) > 멀쩡한 사각형
public class Solution {
    public long solution(int w, int h) {
        long totalSquares = (long) w * (long) h;
        long wasteSquares = (w + h) - (BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue());

        return totalSquares - wasteSquares;
    }
}
