package practice.level1.failure_rate;

import java.util.*;

class Stage implements Comparable {
    int count;
    double failRate;
    int stageNum;

    public Stage(int stageNum) {
        this.stageNum = stageNum;
    }

    @Override
    public int compareTo(Object o) {
        Stage compareStage = (Stage) o;
        if (this.failRate == compareStage.failRate) {
            return Integer.compare(this.stageNum, compareStage.stageNum);
        }
        return Double.compare(compareStage.failRate, this.failRate);
    }
}

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answers = new int[N];
        Stage[] arr = new Stage[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Stage(i + 1);
        }
        for (int i : stages) {
            if (i <= N) {
                arr[i - 1].count++;
            }
        }

        int size = stages.length;
        for (Stage stage : arr) {
            if (stage.count == 0 || size == 0) {
                stage.failRate = 0.0;
            } else {
                stage.failRate = stage.count / (double) size;
                size = size - stage.count;
            }
        }

        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            answers[i] = arr[i].stageNum;
        }
        return answers;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        solution.solution(5, stages);
    }
}
