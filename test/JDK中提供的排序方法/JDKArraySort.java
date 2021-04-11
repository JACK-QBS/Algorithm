package useJDK;

import java.util.*;

public class JDKArraySort {
    private static String[] names = {"蔡徐坤","欧文","詹姆斯","科比","林丹"};

    private static Person[] createPersonArray() {
        Person[] people = new Person[5];
        for (int i = 0; i < 5; i++) {
            people[i] = new Person();
        }
        List<String> nameList = new ArrayList<>(Arrays.asList(names));
        Collections.shuffle(nameList);//将名字打乱
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            people[i].name = nameList.remove(0);
            people[i].age = random.nextInt(30) + 5;
            people[i].height = random.nextInt(100) + 100;
            people[i].weight = random.nextInt(100) + 100;
        }
        return people;
    }

    public static void main(String[] args) {
        Person[] person = createPersonArray();
        System.out.println(Arrays.toString(person));
        Arrays.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });
        System.out.println(Arrays.toString(person));
    }
}
