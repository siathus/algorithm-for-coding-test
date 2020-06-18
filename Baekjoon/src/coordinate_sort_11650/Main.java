package coordinate_sort_11650;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ArrayList<Integer> list;
            if (map.containsKey(x)) {
                list = map.get(x);
                list.add(y);
            } else {
                list = new ArrayList<>();
                list.add(y);
            }
            map.put(x, list);
        }
        Iterator i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry e = (Map.Entry) i.next();
            int x = (int) e.getKey();
            ArrayList<Integer> list = (ArrayList) e.getValue();
            Collections.sort(list);
            for (int y : list) {
                System.out.println(x + " " + y);
            }
        }
    }
}
