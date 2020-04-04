import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StaticExampleTests extends AbstractTestBase {

    private static List<String> list;

    @BeforeClass
    public static void setupGlobal() {
        list = new ArrayList<>();
    }

    @AfterClass
    public static void readList() {
        System.out.println(list);
    }

    @Test
    public void test1() {
        list.add("test1");
    }

    @Test
    public void test2() {
        list.add("test2");
    }

    @Test
    public void test3() {
        list.add("test3");
    }

    @Test
    public void test4() {
        list.add("test4");
    }

    @Test
    public void test5() {
        list.add("test5");
    }

    @Test
    public void test6() {
        list.add("test6");
    }
}
