package dayfore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {

        /*int i = 0;
        boolean doNext = true;

        // Выход через невыполнение условия doNext
        while (doNext) {
            System.out.println(i);

            if (i < 10) {
                i++;
                continue;
            }

            doNext = false;
        }


        // Выход через break;
        i = 0;

        while (true) {
            System.out.println(i);

            if (i < 10) {
                i++;
                continue;
            }

            break;
        }

        // Сначала код потом условие
        do {
            doNext = true;
            boolean elementIsVisible = false;

            int result = new Random().nextInt(5);

            elementIsVisible = result <= 1;

            if (elementIsVisible) {
                doNext = false;
            }
        } while (doNext);

        for (int j = 0; j < 10; j++) {
            System.out.println(j);
        }


        int[] abc = {1, 2, 3, 4, 5, 10};
        // Перебор каждого элемента массива
        for (int k : abc) {
            System.out.println(k);
        }
        // перебор по индексу
        for (int j = 0; j < abc.length; j += 2) {
            System.out.println(abc[j]);
        }
        // ^^^^^ оба цикла здесь равносильны

        int rand = new Random().nextInt(10);

        // "Ответвление"
        if (rand > 5) {
            System.out.println("Random result more than 5");
        }

        // "Разветвление"
        if (rand > 5) {
            System.out.println("Random result more than 5");
        } else {
            System.out.println("Random result less or equals 5");
        }

        // Множественнное "разветвление"
        if (rand > 5) {
            System.out.println("Random result more than 5");
        } else if (rand == 0) {
            System.out.println("Random result equals 0");
        } else {
            System.out.println("Random result less or equals 5");
        }


        rand = new Random().nextInt(5);
        switch (rand) {
            case 5:
                System.out.println("Random result equals 5");
                break;
            case 0:
                System.out.println("Random result equals 0");
                break;
            case 1:
                System.out.println("Random result equals 1");
            case 2:
                System.out.println("Random result equals 1 or 2");
                break;
            default:
                System.out.println("Random result equals ???");
        }

        Roles role = Roles.ADMIN;
        // После назначения роли
        switch (role) {
            case ADMIN:
                addAdminRole();
            case USER:
                addUserRole();
            case GUEST:
                addDefaultRole();
        }

        for (int j = 0; j < 10; j++) {
            System.out.println(Roles.of(j % 3)); // Остаток от деления - %
        }*/

        //        Integer[] initial =  {1,2,3,6,4,5};

        //Arrange
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "open bill");
        map.put(2, "close bill");
        map.put(3, "get credit");
        map.put(4, "close credit");
        map.put(5, "partial close");
        map.put(6, "fail payment");

        Set<Integer> possibleStatuses = map.keySet();
        createRecordsWithStatuses(possibleStatuses);

        // Act
        List<String> result = getRecordsFromUI();

        // Assert
        List<String> expected = new ArrayList<>();
        for (int j = 0; j < possibleStatuses.size(); j++) {
            Integer initVal = (Integer) possibleStatuses.toArray()[j];

            if (map.containsKey(initVal)) {
                String mappedVal = map.get(initVal);

                expected.add(mappedVal);
            } else {
                expected.add("Unknown key " + initVal);
            }
        }

        System.out.println(expected);
        System.out.println(result);

        expected.removeAll(result);
        if(expected.size()!=0){
            //ERROR
            System.out.println(expected);
        }


    }

    private static List<String> getRecordsFromUI() {
        List<String> result = new ArrayList<>();
        result.add("open bill");
        result.add("close bill");
        result.add("get credit");
        result.add("close credit");
        result.add("partial close");
        result.add("fail payment");
        return result;
    }

    private static void createRecordsWithStatuses(Set<Integer> possibleStatuses) {
        // method zaglushka (mock)
        // uslovno dlya kajdogo statusa
        // sozdaet v baze dannih zapis s takim statusom
    }

    static void addDefaultRole() {

    }

    static void addUserRole() {

    }

    static void addAdminRole() {

    }

    public enum Roles {
        GUEST(0),
        USER(1),
        ADMIN(2);

        int value;

        Roles(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Roles of(int value) {
            return Stream.of(Roles.values())
                .filter(p -> p.getValue() == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        }
    }
}
