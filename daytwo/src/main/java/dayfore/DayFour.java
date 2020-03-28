package dayfore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DayFour {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "", "c", "", "d", "", "e", "", "f");

        List<String> result = list.stream().filter(s -> {
            if (s == null) {
                return false;
            }

            return !s.isEmpty();

        }).collect(Collectors.toList());

        System.out.println(result);

        result = new ArrayList<>();   // Вместо collect(Collectors.toList())
        for (String s : list) {        // Вместо лямбда-выражения
            if (s == null || s.isEmpty()) {
                continue;
            }

            result.add(s);      //необходимо т.к. результат нужно куда-то сохранить
            // при работе с потоком результат сохранится там же
        }

        list.stream()
            .filter(s -> s!=null && !s.isEmpty())
            .filter(notEmptyStringPredicate())
            .collect(Collectors.toList());

        list.stream()
            .filter(String::isEmpty) //к сожалению нужно использовать "не" (!) но нельзя
            .collect(Collectors.toList());  //обратный предыдущему результат (вернет пустые)

        List<User> list1 = list.stream().map(str -> {
            User u = new User();
            if (str == null || str.isEmpty()) {
                u.name = "unknown";
                return u;
            }
            u.name = str;
            return u;
        }).collect(Collectors.toList());

        List<User> list2 = list.stream()
            .map(User::new)
            .collect(Collectors.toList());

        List<Company> listCompanies = list.stream()
            .map(Company::new)
            .collect(Collectors.toList());

        // Смотреть в этот метод когда пройдем рефлексию
        List<Company> resultCompanies = stringsToCompanies(list, CompanyNext.class);

        Map<String, User> map = new HashMap<>();
        map.put("M", new User("M"));
        map.put("F", new User("F"));
        map.put("", new User("unknown"));
        map.put(null, new User("unknown"));

        for (String s : list) {
            if (s == null || s.isEmpty()) {
                new User("unknown");
            } else if (s.equals("M")) {
                new User("M");
            } else if (s.equals("F")) {
                new User("M");
            }
        }

        for (String s : list) {
            if (map.containsKey(s)) {
                User user = map.get(s);
            }
        }
    }

    private static Predicate<? super String> notEmptyStringPredicate() {
        return x -> x!=null && !x.isEmpty();
    }


    public static <T extends Company> List<T> stringsToCompanies(List<String> base, Class<? extends T> klass) {
        List<T> listCompanies = base.stream()
            .map(str -> {
                try {
                    // new Company(str)
                    // or new CompanyNext(str) в зависимости от типа klass
                    return klass.getDeclaredConstructor(String.class).newInstance(str);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            })
            .collect(Collectors.toList());
        return listCompanies;
    }

    public static class User {

        public Integer id;

        public String name;

        public User() {
        }

        public User(String name) {
            if (name == null || name.isEmpty()) {
                this.name = "unknown";
            }
            this.name = name;
        }
    }

    public static class Company {

        public String name;

        public Company() {
        }

        public Company(String name) {
            if (name == null || name.isEmpty()) {
                this.name = "unknown";
            }
            this.name = name;
        }
    }

    public static class CompanyNext extends Company {

        public String name;

        private String website;

        public CompanyNext() {
        }

        public CompanyNext(String name) {
            if (name == null || name.isEmpty()) {
                this.name = "unknown";
            }
            this.name = name;
            this.website = name + ".com";
        }
    }

}
