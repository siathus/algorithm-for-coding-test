package naver_webtoon.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ans = s.solution("abxyqwertyxyab");
        Arrays.stream(ans).forEach(System.out::println);
    }
    public String[] solution(String s) {
        List<String> leftPieces = new ArrayList<>();
        List<String> rightPieces = new ArrayList<>();

        int pieceLength = 1;
        int leftIndex = 0, rightIndex = s.length();
        while (leftIndex < rightIndex) {
            String left = s.substring(leftIndex, leftIndex + pieceLength);
            String right = s.substring(rightIndex - pieceLength, rightIndex);
            if (left.equals(right)) {
                if (leftIndex + pieceLength == rightIndex && rightIndex - pieceLength == leftIndex) {
                    leftPieces.add(left);
                    break;
                }
                leftPieces.add(left);
                rightPieces.add(right);
                leftIndex = leftIndex + pieceLength;
                rightIndex = rightIndex - pieceLength;

                pieceLength = 1;
            } else {
                pieceLength++;
            }
        }

        Collections.reverse(rightPieces);
        leftPieces.addAll(rightPieces);
        return leftPieces.toArray(new String[0]);
    }
}
