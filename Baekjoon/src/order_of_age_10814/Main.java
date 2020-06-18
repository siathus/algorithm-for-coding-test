package order_of_age_10814;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        TreeMap<Integer, LinkedList<String>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(" ");
            int age = Integer.parseInt(tmp[0]);
            LinkedList<String> list;
            if (map.containsKey(age)) {
                list = map.get(age);
                list.add(tmp[1]);
                map.replace(age, list);
            } else {
                list = new LinkedList<>();
                list.add(tmp[1]);
                map.put(age, list);
            }
        }
        Iterator i = map.entrySet().iterator();

        while (i.hasNext()) {
            Map.Entry e = (Map.Entry) i.next();
            int key = (int) e.getKey();
            LinkedList<String> value = (LinkedList) e.getValue();
            for (String str : value) {
                System.out.println(key + " " + str);
            }
        }
    }
}
