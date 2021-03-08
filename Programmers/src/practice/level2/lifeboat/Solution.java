package practice.level2.lifeboat;

import java.util.Arrays;

public class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);

        int leftIndex = 0, rightIndex = people.length - 1;

        while (leftIndex <= rightIndex) {
            count++;
            int firstWeight = people[rightIndex];
            int leftWeight = limit - firstWeight;

            rightIndex--;

            if (leftWeight < people[leftIndex]) {
                continue;
            }
            leftIndex++;
        }
        return count;
    }
}
