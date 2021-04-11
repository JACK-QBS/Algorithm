package useJDK;

import java.util.*;

public class JDKListSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(8);
        list.add(5);
        list.add(9);
        System.out.println(list);
        Collections.sort(list);
        /*list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });*/
        System.out.println(list);
    }
}
