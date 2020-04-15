import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

@SuppressWarnings("ALL")
public class CalculatorTests  extends AbstractTestBase{

    // Gherkin annotation (cucumber)
    // BDD - Behavior driven development
    // Given (a = 3 and b = 0)
    // When (a + b)
    // Then result = 3;

    // As a user I should be able to login
    //  ^^^^^^^^^
    // Given as a user
    // Given on the homepage
    // When I click Login button
    // Then Login popup is opened
    // Then fields areFireworksExist enabled

    private Calculator calc;

    @BeforeClass
    public static void beforeClass() throws IOException {
        System.out.println("Before class: initialize process");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After class");
    }

    @Before
    public void setUp2() {
        System.out.println("Set Up2: empty method.");
    }

    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Set Up: initialize new Calculator.");
    }

    @After
    public void tearDown() {
        calc = null;
        System.out.println("Tear Down: destroy our Calculator instance.");
    }

    @Test
    @Ignore
    public void alwaysFailedTest() {
        // Arrange - prepare initial data
        Float a = 3.5f;
        Float b = 2f;

        // Act - do something with out context (call some method against our data)
        Float actual = calc.plus(a, b);

        // Assert - check that the result of our method is valid
        assert actual == 5f;

    }

    @Test
    public void simplePlusTest() {
        System.out.println("Run simplePlusTest.");
        // Arrange - prepare initial data
        Float a = 3.5f;
        Float b = 2f;

        // Act - do something with out context (call some method against our data)
        Float actual = calc.plus(a, b);

        // Assert - check that the result of our method is valid
        assert actual == 5.5f;
        assert actual == a + b; //не повторять алгоритм разработчика иначе бесполезный тест
    }

    @Test
    public void minCalcTest() {
        System.out.println("Run minCalcTest.");
        // Arrange - prepare initial data
        Float a = 3.5f;
        Float b = 2f;

        // Act
        Float actual = calc.minus(a, b);

        // Assert
        assert actual == 1.5f;
    }

    @Test
    public void multiplyCalcTest() {
        System.out.println("Run multiplyCalcTest.");
        // Arrange - prepare initial data
        Float a = 3.5f;
        Float b = 2f;

        // Act
        Float actual = calc.multiply(a, b);

        // Assert
        assert actual == 7f;
    }

    @Test
    @Ignore
    public void divideTest() {
        System.out.println("Run divideCalcTest.");
        // Arrange - prepare initial data
        Float a = 4.4f;
        Float b = 2f;

        // Act
        Float act = calc.divide(a, b);


        // Assert
        assert act == 2.2f;
    }

    @Test
    public void divideByZeroTest() {
        System.out.println("Run divideByZeroTest.");
        // Arrange - prepare initial data
        Float a = 3f;
        Float b = 0f;

        // Act
        Float actual = calc.divide(a, b);

        // Assert
        assert actual == Float.POSITIVE_INFINITY;
    }

    @Test(expected = Exception.class)
    public void nullPointerTest() {
        System.out.println("Run nullPointerTest.");
        // Arrange - prepare initial data
        Float a = 3f;

        // Act
        calc.plus(a, null);
    }

    @Test
    @Ignore
    public void wrongTypedTest() {
        assert calc.plus(3f, 2f) == 5f;
    }

    @Test
    @Ignore
    public void templateTest() {
        // Arrange - prepare initial data
        Float a = 3.5f;
        Float b = 2f;

        // Act

        // Assert
    }
}


/*

    junit ищет классы у которых есть методы с аннотацией @Test (defaultTest() в классе CalculatorTests в нашем случае)
    найдя список этих классов/методов, для каждого метода создает экземпляр его класса
    CalculatorTests ct = new CalculatorTests();
    ct.defaultTest();

    CalculatorTests ct2 = new CalculatorTests();
    ct2.defaultTest2();

    Method[] beforeMethods = reflectivelyGetAllBeforeMethods();
    Method[] afterMethods = reflectivelyGetAllAfterMethods();

    ct.before();
    ct.defaultTest();
    ct.after();

    // Getters

            Method[] allMethods = CalculatorTests.class.getMethods();
            List<Method> tests = new ArrayList<>();
            for (Method m : allMethods) {
                Test annotation = m.getAnnotation(Test.class);
                if (annotation != null) {
                    tests.add(m);
                }
            }

            List<Method> before = new ArrayList<>();
            for (Method m : allMethods) {
                Before annotation = m.getAnnotation(Before.class);
                if (annotation != null) {
                    before.add(m);
                }
            }

            List<Method> after = new ArrayList<>();
            for (Method m : allMethods) {
                After annotation = m.getAnnotation(After.class);
                if (annotation != null) {
                    after.add(m);
                }
            }

            List<Method> beforeClass = new ArrayList<>();
            for (Method m : allMethods) {
                BeforeClass annotation = m.getAnnotation(BeforeClass.class);
                if (annotation != null) {
                    beforeClass.add(m);
                }
            }

            List<Method> afterClass = new ArrayList<>();
            for (Method m : allMethods) {
                AfterClass annotation = m.getAnnotation(AfterClass.class);
                if (annotation != null) {
                    afterClass.add(m);
                }
            }

            // Logic
            CalculatorTests ct = new CalculatorTests();

            // RUN ALL BEFORE CLASS METHODS
            CalculatorTests.beforeClass();

            for (Method test : tests) {

                // RUN ALL BEFORE METHODS
                before.forEach(bf->bf.invoke(ct));

                // RUN CURRENT TEST
                test.invoke(ct);

                // RUN ALL AFTER METHODS
                after.forEach(aft->aft.invoke(ct));

            }

            // RUN ALL AFTER CLASS METHODS
            CalculatorTests.afterClass();


            СТРУКТУРА ХУКОВ И ТЕСТОВ:

            (состояние инициализируемое здесь - работает в единственном экземпляре для всех тестов)
            BeforeClass - запустить калькулятор

            Before - сбросить значение в 0
            Test - посчитать a+b
            After - сделать скриншот результата

            Before - сбросить значение в 0
            Test - посчитать a-b
            After - сделать скриншот результата

            Before - сбросить значение в 0
            Test - посчитать a*b
            After - сделать скриншот результата

            Before - сбросить значение в 0
            Test - посчитать a/b
            After - сделать скриншот результата

            AfterClass - закрыть калькулятор

*/