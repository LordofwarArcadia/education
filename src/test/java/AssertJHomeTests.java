import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJHomeTests {

    @Test
    public void templateForOne() {
        UserDb expected = new UserDb();
        expected.age = 30;
        expected.isActive = true;
        expected.lastLoggedIn = new Date();
        expected.name = "Ivan Ivanov";

        UserResponse actual = new UserResponse();
        expected.age = 30;
        expected.isActive = true;
        expected.lastLoggedIn = new Date();
        expected.name = "Ivan Ivanov";

        assertThat(actual)
            .isNotNull();
        // Продолжить ассерты так чтобы проверить равенство двух объектов (actual и expected)
    }

    @Test
    public void templateForMany() {

        //save to DB like
        List<UserDb> listExpected = IntStream.range(0, 10).mapToObj(x -> {
            UserDb user = new UserDb();
            user.age = 20 + x;
            user.name = "name#" + x;
            user.isActive = x % 2 == 0;
            user.lastLoggedIn = user.isActive ? new Date() : null;
            return user;
        }).collect(Collectors.toList());

        // like we get from API these users
        List<UserResponse> listActual = IntStream.range(0, 10).mapToObj(x -> {
            UserResponse user = new UserResponse();
            user.age = 20 + x;
            user.name = "name#" + x;
            user.activity = new Activity();
            user.activity.isActive = x % 2 == 0;
            user.activity.lastLoggedIn = listExpected.get(x).lastLoggedIn;
            return user;
        }).collect(Collectors.toList());

        assertThat(listActual)
            .hasSize(listExpected.size());
        // дальше продолжить равенство двух массивов.
        // можно сделать двумя вариантами: через API assertJ (extracting &  new Tuple())
        // второй - через кастомный Condition<UserResponse>();

    }

    public class UserDb {

        public String name;

        public Integer age;

        public Boolean isActive;

        public Date lastLoggedIn;
    }

    /* UserResponse:
      {
        "name":"name",
        "age":25,
        "activity":{
            "isActive":true,
            "lastLoggedIn":"2020-06-06T15:50:47Z"
        }
      }
     */
    public class UserResponse {

        public String name;

        public Integer age;

        public Activity activity;
    }

    public class Activity {

        public Boolean isActive;

        public Date lastLoggedIn;
    }


    public static Condition<UserResponse> validBlaBla(UserDb expected) {
        return new Condition<>(actual -> {
            if (!expected.name.equals(actual.name)) return false;
            return actual.equals(expected);
        },
            "Comparing address, name and companyId, expected to see: " + expected.toString());
    }
}
