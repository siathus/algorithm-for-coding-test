package practice.level2.bridge_truck;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bridgeWeight = 0;

        int[] bridge = new int[bridge_length];

        List<Integer> trucks = new ArrayList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            trucks.add(truck_weights[i]);
        }

        while (true) {
            time++;
            if (bridge[bridge_length - 1] != 0) {
                bridgeWeight -= bridge[bridge_length - 1];
                bridge[bridge_length - 1] = 0;
            }
            for (int i = bridge.length - 1; i >= 0; i--) {
                if (bridge[i] != 0) {
                    bridge[i + 1] = bridge[i];
                    bridge[i] = 0;
                }
            }
            if (trucks.isEmpty() == false) {
                int currentTruck = trucks.get(0);
                if (bridgeWeight + currentTruck <= weight) {
                    bridgeWeight += currentTruck;
                    trucks.remove(0);
                    bridge[0] = currentTruck;
                }
            }

            if (trucks.size() == 0 && bridgeWeight == 0) {
                break;
            }
        }
        return time;
    }
}
